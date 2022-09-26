package com.benjamin.service.impl;

import com.benjamin.entities.President;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.service.PresidentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 总统 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Service
public class PresidentServiceImpl extends ServiceImpl<PresidentMapper, President> implements PresidentService {

}
