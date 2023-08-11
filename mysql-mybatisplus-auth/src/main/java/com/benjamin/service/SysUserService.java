package com.benjamin.service;

import com.benjamin.entities.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.request.SysUserReq;
import com.benjamin.response.BaseResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-13
 */
public interface SysUserService extends IService<SysUser> {

    BaseResponse insertSysUer(SysUserReq sysUserReq);

    BaseResponse login(SysUserReq sysUserReq);
}
