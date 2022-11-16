package com.benjamin.controller;


import com.benjamin.request.SysUserRequest;
import com.benjamin.response.BaseResponse;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysUserService;
import io.swagger.annotations.Api;
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
     * @param sysUserRequest
     * @return
     */
    @PostMapping("/insert")
    @ApiOperation("新增用户")
    public BaseResponse insertSysUer(SysUserRequest sysUserRequest) {
        return sysUserService.insertSysUer(sysUserRequest);
    }

    /**
     * 用户登录
     * @param sysUserRequest
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public BaseResponse login(SysUserRequest sysUserRequest) {
        return sysUserService.login(sysUserRequest);
    }
}

