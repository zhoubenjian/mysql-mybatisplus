package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.President;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.PresidentVo;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 总统 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
public interface PresidentService extends IService<President> {

    /**
     * 所有总统
     * @return
     */
    ResponseWithEntities<List<PresidentVo>> queryAllPresident();

    /**
     * 在世总统
     * @return
     */
    ResponseWithEntities<List<PresidentVo>> queryAlivePresident();

    /**
     *
     * @return
     */
    ResponseWithEntities<List<PresidentVo>>  queryPresidentByBirthDate(String startTime, String endTime);
}
