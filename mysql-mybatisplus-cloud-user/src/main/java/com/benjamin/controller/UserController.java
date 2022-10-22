package com.benjamin.controller;

import com.benjamin.entities.User;
import com.benjamin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 根据userId查询user
     * @param userId
     * @return
     */
    @GetMapping("{userId}")
    public User queryUserByUserId(@PathVariable("userId") Long userId) {
        return userService.queryUserByUserId(userId);
    }
}

