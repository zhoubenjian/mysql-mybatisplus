package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.State;
import com.benjamin.entities.StatePresident;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 州 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
public interface StateMapper extends BaseMapper<State> {

    /**
     * 条件查询州
     * @param stateName
     * @param stateCapital
     * @param governor
     * @return
     */
    List<State> queryStateByCondition(@Param("stateName") String stateName,
                                      @Param("stateCapital") String stateCapital,
                                      @Param("governor") String governor);

    /**
     * 州对应的总统(一对多)
     * @return
     */
    List<StatePresident> queryStateWithPresident();
}
