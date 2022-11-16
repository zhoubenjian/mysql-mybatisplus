package com.benjamin.error;

import com.benjamin.exception.WebException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SystemErrors {

    NEED_LOGIN(2001L, "没有登录", "没有登录"),

    USER_NOT_FOUND(30001L, "用户不存在", "用户不存在"),
    ;



    private final long code;

//    private final long status;

    private final String message;

    private final String view;

//    SystemErrors(long code, long status, String message, String view) {
//        this.code = code;
//        this.status = status;
//        this.message = message;
//        this.view = view;
//    }

    public WebException getException() {
        return new WebException(this.message, this.code, this.view);
    }
}
