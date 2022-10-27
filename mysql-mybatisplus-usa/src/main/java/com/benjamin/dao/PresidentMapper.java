package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.President;
import com.benjamin.vo.PresidentStateVo;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 出生日期查询
     * @param startTime
     * @param endTime
     * @return
     */
    List<President> queryPresidentByBirthDate(@Param("startTime") String startTime,
                                              @Param("endTime") String endTime);

    /**
     * 总统对应的州(一对一)
     * @return
     */
    List<PresidentStateVo> queryPresidentWithState();
}
