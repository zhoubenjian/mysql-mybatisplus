package com.benjamin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.ApiConverter;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.entities.President;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.benjamin.vo.PresidentVo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<PresidentVo> presidentVoList = apiConverter.PresidentList2PresidentVoList(presidentList);
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
        List<President> presidentList = presidentMapper.queryAlivePresident();
        List<PresidentVo> presidentVoList = apiConverter.PresidentList2PresidentVoList(presidentList);
        // 获取当前年份
        LocalDate now = LocalDate.now();
        // 计算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }
}
