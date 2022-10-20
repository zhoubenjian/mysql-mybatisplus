package com.benjamin.controller;


import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PartyService;
import com.benjamin.vo.PartyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 政党 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
@Api(value = "政党接口", tags = {"政党接口"})
@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;



    /**
     * 现存政党
     * @return
     */
    @ApiOperation("现存政党")
    @GetMapping("/exist")
    public ResponseWithEntities<List<PartyVo>> queryExistParty() {
        return partyService.queryExistParty();
    }

    /**
     * 表单提交（多文件提交只能使用Postman测试）
     * @param file
     * @param files
     * @return
     */
    @PostMapping("/create")
    @ApiOperation("表单提交")
    public boolean create(MultipartFile file, MultipartFile[] files) {
        return partyService.create(file, files);
    }
}

