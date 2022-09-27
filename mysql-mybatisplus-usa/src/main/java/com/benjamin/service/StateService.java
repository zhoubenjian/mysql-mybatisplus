package com.benjamin.service;

import com.benjamin.entities.State;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.StateVo;

import java.util.List;

/**
 * <p>
 * 州 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-09-27
 */
public interface StateService extends IService<State> {

    ResponseWithEntities<List<StateVo>> queryAllState();
}
