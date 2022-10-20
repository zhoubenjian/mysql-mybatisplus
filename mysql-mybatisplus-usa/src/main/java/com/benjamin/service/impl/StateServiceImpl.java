package com.benjamin.service.impl;

import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.ApiConverter;
import com.benjamin.entities.State;
import com.benjamin.dao.StateMapper;
import com.benjamin.request.BasePageRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.StateVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private ApiConverter apiConverter;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    private static final String allStateKey = "AllState";



    /**
     * 查询所有州
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
            // 数据库查询
            stateList = stateMapper.selectList(null);
            // 写入redis
            opsForValue.set(key, stateList);
            // 过期时间
            redisTemplate.expireAt(key, DateUtils.addDays(new Date(), 1));
        }

        List<StateVo> stateVoList = apiConverter.stateListToStateVoList(stateList);
        return new ResponseWithEntities<List<StateVo>>().setData(stateVoList);
    }

    /**
     * 分页查询州
     * @param basePageRequest
     * @return
     */
    @Override
    public ResponseWithCollection<StateVo> queryStateByPage(BasePageRequest basePageRequest) {
        Page<State> page = PageHelper.startPage((int) basePageRequest.getPage(), (int) basePageRequest.getPageSize());
        List<State> stateList = stateMapper.selectList(null);
        List<StateVo> stateVoList = apiConverter.stateListToStateVoList(stateList);
        return ResponseWithCollection.buildResponse(basePageRequest, stateVoList, page.getTotal());
    }

    /**
     * 州对应的总统(一对多)
     * @param basePageRequest
     * @return
     */
    @Override
    public ResponseWithCollection<StateVo> queryStateWithPresident(BasePageRequest basePageRequest) {
        Page<State> page = PageHelper.startPage((int) basePageRequest.getPage(), (int) basePageRequest.getPageSize());
        List<State> list = stateMapper.queryStateWithPresident();
        List<StateVo> stateVoList = apiConverter.stateListToStateVoList(list);
        return ResponseWithCollection.buildResponse(basePageRequest, stateVoList, page.getTotal());
    }
}
