package com.benjamin.controller;


import com.benjamin.request.SysUserReq;
import com.benjamin.response.BaseResponse;
import com.benjamin.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;



    /**
     * 新增用户
     * @param sysUserReq
     * @return
     */
    @PostMapping("/insert")
    @ApiOperation("新增用户")
    public BaseResponse insertSysUer(SysUserReq sysUserReq) {
        return sysUserService.insertSysUer(sysUserReq);
    }

    /**
     * 用户登录
     * @param sysUserReq
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public BaseResponse login(SysUserReq sysUserReq) {
        return sysUserService.login(sysUserReq);
    }
}

