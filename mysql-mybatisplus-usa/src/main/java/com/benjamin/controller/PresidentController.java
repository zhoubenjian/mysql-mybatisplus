package com.benjamin.controller;


import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.benjamin.vo.PresidentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 总统 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@Api(value = "总统接口", tags = {"总统接口"})
@RestController
@RequestMapping("/president")
public class PresidentController {

    @Autowired
    private PresidentService presidentService;



    /**
     * 所有总统
     * @return
     */
    @GetMapping("all")
    @ApiOperation("所有总统")
    public ResponseWithEntities<List<PresidentVo>> queryAllPresident() {
        return presidentService.queryAllPresident();
    }

    /**
     * 在世总统
     * @return
     */
    @GetMapping("/alive")
    @ApiOperation("在世总统")
    public ResponseWithEntities<List<PresidentVo>> queryAlivePresident() {
        return presidentService.queryAlivePresident();
    }

    /**
     * 出生日期查询
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/birthday")
    @ApiOperation("出生日期查询")
    public ResponseWithEntities<List<PresidentVo>> queryPresidentByBirthDate(@RequestParam(value = "startTime", required = false) String startTime,
                                                                             @RequestParam(value = "endTime", required = false) String endTime) {
        return presidentService.queryPresidentByBirthDate(startTime, endTime);
    }
}

