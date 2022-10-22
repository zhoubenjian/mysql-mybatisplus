package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-22
 */
public interface UserService extends IService<User> {

    /**
     * 根据userId查询user
     * @param userId
     * @return
     */
    User queryUserByUserId(Long userId);
}
