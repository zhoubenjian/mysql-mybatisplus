package com.benjamin.controller;

import com.benjamin.service.PointsFlowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分流水表 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/points")
public class PointsFlowController {

    @Autowired
    private PointsFlowService pointsFlowService;



    /**
     * 昨日积分
     */
    @PostMapping("")
    @ApiOperation("昨日积分")
    public void calculateYesterdayPoints() {
        pointsFlowService.calculateYesterdayPoints();
    }
}

