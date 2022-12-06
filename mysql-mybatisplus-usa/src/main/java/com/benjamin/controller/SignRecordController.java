package com.benjamin.controller;

import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SignRecordService;
import com.benjamin.vo.SignVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 签到记录表 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/sign")
public class SignRecordController {

    @Autowired
    private SignRecordService signRecordService;



    /**
     * 签到/签退
     * @param presidentId
     * @return
     */
    @PostMapping("{presidentId}")
    @ApiOperation("签到/签退")
    public ResponseWithEntities<SignVo> sign(@PathVariable("presidentId") Long presidentId) {
        return signRecordService.sign(presidentId);
    }
}

