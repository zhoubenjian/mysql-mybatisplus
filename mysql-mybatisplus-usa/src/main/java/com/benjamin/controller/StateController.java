package com.benjamin.controller;


import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StateService;
import com.benjamin.vo.StateVo;
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
 * @since 2022-10-01
 */
@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;



    /**
     * 查询所有州
     * @return
     */
    @GetMapping("/all")
    public ResponseWithEntities<List<StateVo>> queryAllState() {
        return stateService.queryAllState();
    }
}

