package com.benjamin.dao;

import com.benjamin.entities.President;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.vo.PresidentVo;

import java.util.List;

/**
 * <p>
 * 总统 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
public interface PresidentMapper extends BaseMapper<President> {

    /**
     * 在世总统
     * @return
     */
    List<President> queryAlivePresident();
}
