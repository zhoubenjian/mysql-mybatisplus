package com.benjamin.service;

import cn.dev33.satoken.util.SaResult;
import com.benjamin.dto.SysUserDto;
import com.benjamin.entities.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.SysUserVo;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author benjamin
 * @since 2023-12-16
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 登录
     *
     * @param sysUserDto
     * @return
     */
    ResponseWithEntities<SysUserVo> login(SysUserDto sysUserDto);

    /**
     * 用户列表
     *
     * @return
     */
    ResponseWithEntities<List<SysUserVo>> sysUserList();

    /**
     * 当前用户信息
     *
     * @return
     */
    ResponseWithEntities<SysUserVo> getCurrentSysUser();
}
