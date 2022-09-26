package com.benjamin.service.impl;

import com.benjamin.entities.Party;
import com.benjamin.dao.PartyMapper;
import com.benjamin.service.PartyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 政党 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Service
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {

}
