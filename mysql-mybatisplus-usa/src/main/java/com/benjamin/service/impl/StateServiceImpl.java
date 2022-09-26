package com.benjamin.service.impl;

import com.benjamin.entities.State;
import com.benjamin.dao.StateMapper;
import com.benjamin.service.StateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 州 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService {

}
