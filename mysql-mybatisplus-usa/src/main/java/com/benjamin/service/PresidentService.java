package com.benjamin.service;

import com.benjamin.entities.President;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.PresidentVo;

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
     * 查询所有总统
     * @return
     */
    ResponseWithEntities<List<PresidentVo>> queryAllPresident();
}
