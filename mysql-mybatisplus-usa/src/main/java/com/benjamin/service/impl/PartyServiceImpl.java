package com.benjamin.service.impl;

import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.ApiConverter;
import com.benjamin.entities.Party;
import com.benjamin.dao.PartyMapper;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PartyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.PartyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
@Slf4j
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

        List<Party> partyList = new ArrayList<>();
        if (hasKey != null && hasKey) {
            // redis读取
            partyList = (List<Party>) opsForValue.get(key);
        } else {
            // 数据库查询
            partyList = partyMapper.queryExistParty();
            // 写入redis
            opsForValue.set(key, partyList);
            // 过期时间
            redisTemplate.expireAt(key, DateUtils.addDays(new Date(),1));
        }

        // Party => PartyVo
        List<PartyVo> partyVoList = apiConverter.partyListToPartyVoList(partyList);
        return new ResponseWithEntities<List<PartyVo>>().setData(partyVoList);
    }

    /**
     * 表单提交
     * @param file
     * @param files
     * @return
     */
    @Override
    public boolean create(@RequestParam("file") MultipartFile file, @RequestParam("files") MultipartFile[] files) {
        if (file == null) {
            log.debug("file不能为空");
            return false;
        }
        log.info(file.getOriginalFilename());

        if (files == null || files.length == 0) {
            log.debug("files不能为空");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            if (i == files.length - 1) {
                sb.append(files[i].getOriginalFilename());
            } else {
                sb.append(files[i].getOriginalFilename()).append(",");
            }
        }
        log.info(sb.toString());

        return true;
    }
}
