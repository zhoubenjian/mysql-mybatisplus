package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.State;
import com.benjamin.request.BasePageRequest;
import com.benjamin.request.StateRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.StatePresidentVo;
import com.benjamin.vo.StateVo;

import java.util.List;

/**
 * <p>
 * 州 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
public interface StateService extends IService<State> {

    /**
     * 查询所有州
     *
     * @return
     */
    ResponseWithEntities<List<StateVo>> queryAllState();

    /**
     * 条件查询州
     *
     * @param stateRequest
     * @return
     */
    ResponseWithCollection<StateVo> queryStateByCondition(StateRequest stateRequest);

    /**
     * 分页查询州
     *
     * @param basePageRequest
     * @return
     */
    ResponseWithCollection<StateVo> queryStateByPage(BasePageRequest basePageRequest);

    /**
     * 州对应的总统(一对多)
     *
     * @param basePageRequest
     * @return
     */
    ResponseWithCollection<StatePresidentVo> queryStateWithPresident(BasePageRequest basePageRequest);
}
