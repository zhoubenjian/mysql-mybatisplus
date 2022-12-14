package com.benjamin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.ApiConverter;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.entities.President;
import com.benjamin.entities.PresidentState;
import com.benjamin.request.BasePageRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.benjamin.vo.PresidentStateVo;
import com.benjamin.vo.PresidentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 * 总统 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@Service
public class PresidentServiceImpl extends ServiceImpl<PresidentMapper, President> implements PresidentService {

    @Autowired
    private PresidentMapper presidentMapper;

    @Autowired
    private ApiConverter apiConverter;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    private static final String allPresidentKey = "allPresident";



    /**
     * 所有总统
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>> queryAllPresident() {
        String key = RedisKeyConstant.getAllPresidentInfo(allPresidentKey);
        Boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        List<President> presidentList = new ArrayList<>();
        if (hasKey != null && hasKey) {
            // redis读取
            presidentList = (List<President>) opsForValue.get(key);
        } else {
            // 数据库查询
            presidentList = presidentMapper.selectList(null);
            // 写入redis
            opsForValue.set(key, presidentList);
            // 一天后过期
            redisTemplate.expireAt(key, DateUtils.addDays(new Date(), 1));
        }

        // President => PresidentVo
        List<PresidentVo> presidentVoList = apiConverter.presidentList2PresidentVoList(presidentList);
        LocalDate now = LocalDate.now();
        // 计算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }

    /**
     * 在世总统
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>> queryAlivePresident() {
        List<President> presidentList = Optional.of(presidentMapper.queryAlivePresident()).orElse(Collections.EMPTY_LIST);

        // President => PresidentVo
        List<PresidentVo> presidentVoList = apiConverter.presidentList2PresidentVoList(presidentList);
        // 当前年份
        LocalDate now = LocalDate.now();
        // 计算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }

    /**
     * 出生日期查询
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>>  queryPresidentByBirthDate(String startTime, String endTime) {
        List<President> presidentList = presidentMapper.queryPresidentByBirthDate(startTime, endTime);

        // President => PresidentVo
        List<PresidentVo> presidentVoList = apiConverter.presidentList2PresidentVoList(presidentList);
        // 当前年份
        LocalDate now = LocalDate.now();
        // 计算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }

    /**
     * 总统对应的州(一对一)
     * @param basePageRequest
     * @return
     */
    @Override
    public ResponseWithCollection<PresidentStateVo> queryPresidentWithState(BasePageRequest basePageRequest) {
        Page page = PageHelper.startPage((int) basePageRequest.getPage(), (int) basePageRequest.getPageSize());
        List<PresidentState> presidentStateList = presidentMapper.queryPresidentWithState();

        // PresidentState => PresidentStateVo
        List<PresidentStateVo> presidentStateVoList = apiConverter.presidentState2PresidentStateVoList(presidentStateList);
        return ResponseWithCollection.buildResponse(basePageRequest, presidentStateVoList, page.getTotal());
    }
}
