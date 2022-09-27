package com.benjamin.controller;


import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StateService;
import com.benjamin.vo.StateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 州 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-09-27
 */
@Api(tags = {"州模块"})
@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService service;



    @GetMapping("/all")
    @ApiOperation(value = "所有州信息", notes = "所有州信息")
    public ResponseWithEntities<List<StateVo>> queryAllState() {
        return service.queryAllState();
    }
}

