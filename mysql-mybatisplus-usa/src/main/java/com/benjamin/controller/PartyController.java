package com.benjamin.controller;


import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PartyService;
import com.benjamin.vo.PartyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 政党 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
@Api(tags = "政党 模块")
@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;



    /**
     * 现存政党
     * @return
     */
    @GetMapping("/exist")
    @ApiOperation(value = "现存政党", notes = "现存政党")
    public ResponseWithEntities<List<PartyVo>> queryExistParty() {
        return partyService.queryExistParty();
    }
}

