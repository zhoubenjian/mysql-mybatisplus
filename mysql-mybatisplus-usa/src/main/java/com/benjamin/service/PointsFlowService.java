package com.benjamin.service;

import com.benjamin.entities.PointsFlow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 积分流水表 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
public interface PointsFlowService extends IService<PointsFlow> {

    /**
     * 昨日积分
     */
    void calculateYesterdayPoints();
}
