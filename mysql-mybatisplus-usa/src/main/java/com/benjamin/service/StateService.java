package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.State;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.StateVo;

import java.util.List;

/**
 * <p>
 * 州 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
public interface StateService extends IService<State> {

    /**
     * 查询所有州（不分页）
     * @return
     */
    ResponseWithEntities<List<StateVo>> queryAllState();
}
