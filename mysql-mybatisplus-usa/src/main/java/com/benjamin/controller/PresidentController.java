package com.benjamin.controller;


import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.benjamin.vo.PresidentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 总统 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@RestController
@RequestMapping("/president")
public class PresidentController {

    @Autowired
    private PresidentService presidentService;



    /**
     * 查询所有总统
     * @return
     */
    @GetMapping("all")
    public ResponseWithEntities<List<PresidentVo>> queryAllPresident() {
        return presidentService.queryAllPresident();
    }
}

