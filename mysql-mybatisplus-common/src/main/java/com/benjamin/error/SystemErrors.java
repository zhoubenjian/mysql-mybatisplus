package com.benjamin.error;

import com.benjamin.exception.WebException;

import javax.servlet.http.HttpServletResponse;

public enum SystemErrors {

    NEED_LOGIN(2001L, HttpServletResponse.SC_UNAUTHORIZED, "没有登录", "没有登录"),

    USER_NOT_FOUND(30001L, HttpServletResponse.SC_NOT_FOUND, "用户信息没有找到", "用户信息没有找到"),
    ;



    private final long code;

    private final long status;

    private final String message;

    private final String view;

    SystemErrors(long code, long status, String message, String view) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.view = view;
    }

    public WebException getException() {
        return new WebException(message, code, view, status);
    }
}