package com.benjamin.controller;

import com.benjamin.request.SysRoleReq;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysRoleService;
import com.benjamin.vo.SysRoleVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2023-07-22
 */
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;



    /**
     * 角色列表（不分页）
     *
     * @param enable    可用（默认：true）
     * @return
     */
    @ApiOperation("角色列表（不分页）")
    @GetMapping("/all")
    public ResponseWithEntities<List<SysRoleVo>> sysRoleList(@RequestParam(name = "enable", defaultValue = "true", required = false) Boolean enable) {
        return sysRoleService.sysRoleList(enable);
    }

    /**
     * 添加角色
     *
     * @param sysRoleReq
     * @return
     */
    @ApiOperation("角色列表")
    @PostMapping("/add")
    public ResponseWithEntities<String> addSysRole(@Valid @RequestBody SysRoleReq sysRoleReq) {
        return sysRoleService.addSysRole(sysRoleReq);
    }

    /**
     * 修改角色
     *
     * @param sysRoleVo
     * @return
     */
    @ApiOperation("角色列表")
    @PutMapping("/update")
    public ResponseWithEntities<String> updateSysRoleById(@RequestBody SysRoleVo sysRoleVo) {
        return sysRoleService.updateSysRoleById(sysRoleVo);
    }

    /**
     * 批量删除/恢复 角色（逻辑）
     *
     * @param ids       主键
     * @param enable    是否可用, 0:不可用；1:可用（默认）
     * @return
     */
    @ApiOperation("批量删除/恢复 角色（逻辑）")
    @PutMapping("/reset")
    public ResponseWithEntities<String> resetSysRolesByIds(@RequestParam("ids") List<Long> ids,
                                                           @RequestParam("enable") Integer enable) {
        return sysRoleService.resetSysRolesByIds(ids, enable);
    }
}

