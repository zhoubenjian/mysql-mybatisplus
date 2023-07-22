package com.benjamin.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor
@Accessors(chain = true)
public enum SystemErrors {

    /*** mysql-mybatisplus-usa ***/
    // 用户已存在
    USER_FOUND(30001L, HttpServletResponse.SC_FOUND, "用户已存在", "用户已存在"),

    // 用户不存在
    USER_NOT_FOUND(30002L, HttpServletResponse.SC_NOT_FOUND, "用户不存在", "用户不存在"),

    // 用户名或密码不正确
    USER_NAME_PASSWORD_WRONG(30003L, 30003, "用户名或密码不正确", "用户名或密码不正确"),


    // 文件不能为空
    FILE_NOT_NULL(40001L, 40001, "file不能为空", "file不能为空"),


    // 总统已故
    PRESIDENT_NOT_ALIVE(50001L, 50001, "总统已故", "总统已故"),



    /*** mysql-mybatisplus-new-auth ***/
    // 角色已存在
    ROLE_ALREADY_EXIST(30101L, 30101, "角色已存在", "角色已存在"),
    ;



    private final long code;

    private final long status;

    private final String message;

    private final String view;
}
