package com.benjamin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.UsaConverter;
import com.benjamin.entities.State;
import com.benjamin.dao.StateMapper;
import com.benjamin.entities.StatePresident;
import com.benjamin.request.BasePageRequest;
import com.benjamin.request.StateRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.StatePresidentVo;
import com.benjamin.vo.StateVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 州 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService {

    @Autowired
    private StateMapper stateMapper;

    @Autowired
    private UsaConverter usaConverter;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    private static final String allStateKey = "AllState";



    /**
     * 查询所有州（2022年GDP排名）
     *
     * @return
     */
    @Override
    public ResponseWithEntities<List<StateVo>> queryAllState() {
        String key = RedisKeyConstant.getAllStateInfo(allStateKey);
        Boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        List<State> stateList = new ArrayList<>();
        if (hasKey != null && hasKey) {

            // redis读取
            stateList = (List<State>) opsForValue.get(key);

        } else {

            QueryWrapper<State> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByAsc("`rank`");  // 关键字 `rank` 转义
            // 数据库查询
            stateList = stateMapper.selectList(queryWrapper);

            if (stateList.size() > 0) {

                // 写入redis
                opsForValue.set(key, stateList);
                // 过期时间(一天)
                redisTemplate.expireAt(key, DateUtils.addDays(new Date(), 1));
            }
        }

        // State => StateVo
        List<StateVo> stateVoList = usaConverter.stateListToStateVoList(stateList);
        return new ResponseWithEntities<List<StateVo>>().setData(stateVoList);
    }

    /**
     * 条件查询州
     *
     * @param stateRequest
     * @return
     */
    @Override
    public ResponseWithCollection<StateVo> queryStateByCondition(StateRequest stateRequest) {

        String stateName = stateRequest.getStateName();
        String stateCapital = stateRequest.getStateCapital();
        String governor = stateRequest.getGovernor();

        Page page = PageHelper.startPage((int) stateRequest.getPage(), (int) stateRequest.getPageSize());
        List<State> stateList = stateMapper.queryStateByCondition(stateName, stateCapital, governor);
        List<StateVo> stateVoList = usaConverter.stateListToStateVoList(stateList);

        return ResponseWithCollection.buildResponse(stateRequest, stateVoList, page.getTotal());
    }

    /**
     * 分页查询州
     *
     * @param basePageRequest
     * @return
     */
    @Override
    public ResponseWithCollection<StateVo> queryStateByPage(BasePageRequest basePageRequest) {
        Page page = PageHelper.startPage((int) basePageRequest.getPage(), (int) basePageRequest.getPageSize());
        // Optional避免空指针异常
        List<State> stateList = Optional.of(stateMapper.selectList(null)).orElse(Collections.EMPTY_LIST);

        // State => StateVo
        List<StateVo> stateVoList = usaConverter.stateListToStateVoList(stateList);
        return ResponseWithCollection.buildResponse(basePageRequest, stateVoList, page.getTotal());
    }

    /**
     * 州对应的总统(一对多)
     *
     * @param basePageRequest
     * @return
     */
    @Override
    public ResponseWithCollection<StatePresidentVo> queryStateWithPresident(BasePageRequest basePageRequest) {
        Page page = PageHelper.startPage((int) basePageRequest.getPage(), (int) basePageRequest.getPageSize());
        List<StatePresident> statePresidentList = Optional.ofNullable(stateMapper.queryStateWithPresident())
                .orElse(Collections.EMPTY_LIST);

        // StatePresident => StatePresidentVo
        List<StatePresidentVo> statePresidentVoList = usaConverter.statePresidentList2StatePresidentVoList(statePresidentList);
        return ResponseWithCollection.buildResponse(basePageRequest, statePresidentVoList, page.getTotal());
    }
}
