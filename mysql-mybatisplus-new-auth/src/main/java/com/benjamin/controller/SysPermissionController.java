package com.benjamin.controller;

import com.benjamin.request.SysPermissionReq;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysPermissionService;
import com.benjamin.vo.SysPermissionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
@RestController
@RequestMapping("/sys-permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;



    /**
     * 所有权限
     *
     * @return
     */
    @ApiOperation("所有权限")
    @GetMapping("/all")
    public ResponseWithEntities<List<SysPermissionVo>> allPermissions() {
        return sysPermissionService.allPermissions();
    }

    /**
     * 添加权限
     *
     * @param sysPermissionReq
     * @return
     */
    @ApiOperation("所有权限")
    @PostMapping("/添加权限")
    public ResponseWithEntities<String> addPermission(@Valid @RequestBody SysPermissionReq sysPermissionReq) {
        return sysPermissionService.addPermission(sysPermissionReq);
    }



    /**
     * RabbitMQ队列测试
     *
     * @return
     */
    @ApiOperation("RabbitMQ队列测试")
    @GetMapping("/rabbitmq/test")
    public ResponseWithEntities<String> testRabbitMQ() {
        return sysPermissionService.testRabbitMQ();
    }
}

