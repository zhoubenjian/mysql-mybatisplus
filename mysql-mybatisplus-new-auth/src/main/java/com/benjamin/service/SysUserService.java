package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.SysUser;
import com.benjamin.response.ResponseWithEntities;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 注册
     *
     * @return
     */
    ResponseWithEntities<String> register();
}
