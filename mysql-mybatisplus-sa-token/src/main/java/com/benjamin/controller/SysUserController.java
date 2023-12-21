package com.benjamin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.benjamin.dto.SysUserDto;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysUserService;
import com.benjamin.vo.SysUserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2023-12-16
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;



    /**
     * 登录
     *
     * @param sysUserDto
     * @return
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseWithEntities<SysUserVo> login(@Valid @RequestBody SysUserDto sysUserDto) {
        return sysUserService.login(sysUserDto);
    }

    /**
     * 用户列表
     *
     * @return
     */
    @SaCheckLogin
    @ApiOperation("用户列表")
    @GetMapping("/list")
    public ResponseWithEntities<List<SysUserVo>> sysUserList() {
        return sysUserService.sysUserList();
    }

    /**
     * 当前用户信息
     *
     * @return
     */
    @SaCheckLogin
    @ApiOperation("当前用户信息")
    @GetMapping("/current")
    public ResponseWithEntities<SysUserVo> getCurrentSysUser() {
        return sysUserService.getCurrentSysUser();
    }
}

