package com.benjamin.service.impl;

import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.ApiConverter;
import com.benjamin.entities.Party;
import com.benjamin.dao.PartyMapper;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PartyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.PartyVo;
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
 * 政党 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
@Service
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {

    @Autowired
    private PartyMapper partyMapper;

    @Autowired
    private ApiConverter apiConverter;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    private static final String existPartyKey = "existParty";



    /**
     * 现存政党
     * @return
     */
    @Override
    public ResponseWithEntities<List<PartyVo>> queryExistParty() {
        String key = RedisKeyConstant.getExistPartyInfo(existPartyKey);
        Boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        List<Party> list = new ArrayList<>();
        if (hasKey != null && hasKey) {
            // redis读取
            List<Party> partyList = (List<Party>) opsForValue.get(key);
        } else {
            // 数据库查询
            list = partyMapper.queryExistParty();
            // 写入redis
            opsForValue.set(key, list);
            // 过期时间
            redisTemplate.expireAt(key, DateUtils.addDays(new Date(),1));
        }

        // Party => PartyVo
        List<PartyVo> partyVoList = apiConverter.partyListToPartyVoList(list);
        return new ResponseWithEntities<List<PartyVo>>().setData(partyVoList);
    }
}
