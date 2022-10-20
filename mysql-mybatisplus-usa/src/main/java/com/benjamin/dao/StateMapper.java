package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.State;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
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
     * 州对应的总统(一对多)
     * @return
     */
    List<State> queryStateWithPresident();
}
