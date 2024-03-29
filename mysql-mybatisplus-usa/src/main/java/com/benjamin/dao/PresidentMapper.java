package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.President;
import com.benjamin.entities.PresidentState;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

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
     * Donald Trump
     *
     * @param name
     * @return
     */
    President queryOnePresident(@Param("name") String name);

    /**
     * 在世总统
     *
     * @return
     */
    List<President> queryAlivePresident();

    /**
     * 出生日期查询
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<President> queryPresidentByBirthDate(@Param("startTime") String startTime,
                                              @Param("endTime") String endTime);

    /**
     * 总统对应的州(一对一)
     *
     * @return
     */
    List<PresidentState> queryPresidentWithState();

    /**
     * 流式读取
     *
     * @param key
     * @param resultHandler
     */
    void exportPresidentBySteam(String key, ResultHandler<President> resultHandler);
}
