package com.benjamin.service;

import com.benjamin.entities.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.request.SysUserRequest;
import com.benjamin.response.BaseResponse;
import com.benjamin.response.ResponseWithEntities;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-13
 */
public interface SysUserService extends IService<SysUser> {

    BaseResponse insertSysUer(SysUserRequest sysUserRequest);

    BaseResponse login(SysUserRequest sysUserRequest);
}
