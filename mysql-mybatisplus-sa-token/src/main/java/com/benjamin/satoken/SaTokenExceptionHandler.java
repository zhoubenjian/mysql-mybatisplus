package com.benjamin.satoken;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.NotSafeException;
import com.benjamin.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaTokenExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    public BaseResponse handlerNotLoginException(NotLoginException nle) {

        // 不同异常返回不同状态码
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供Token";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "未提供有效的Token";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "登录信息已过期，请重新登录";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "您的账户已在另一台设备上登录，如非本人操作，请立即修改密码";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "已被系统强制下线";
        } else {
            message = "当前会话未登录";
        }
        // 返回给前端
        return new BaseResponse()
                .setCode(Long.parseLong(nle.getType()))
                .setStatus(Long.parseLong(nle.getType()))
                .setMessage(message)
                .setView(message);
    }

    @ExceptionHandler
    public BaseResponse handlerNotRoleException(NotRoleException e) {
//        return RES.no(403, "无此角色：" + e.getRole());
        return new BaseResponse()
                .setCode(403L)
                .setStatus(403L)
                .setMessage(e.getRole())
                .setView("无此角色！");
    }

    @ExceptionHandler
    public BaseResponse handlerNotPermissionException(NotPermissionException e) {
//        return RES.no(403, "无此权限：" + e.getCode());
        return new BaseResponse()
                .setCode(403L)
                .setStatus(403L)
                .setMessage(e.getMessage())
                .setView("无此权限！");
    }

//    @ExceptionHandler
//    public BaseResponse handlerDisableLoginException(DisableLoginException e) {
//        return RES.no(401, "账户被封禁：" + e.getDisableTime() + "秒后解封");
//    }

    @ExceptionHandler
    public BaseResponse handlerNotSafeException(NotSafeException e) {
//        return RES.no(401, "二级认证异常：" + e.getMessage());
        return new BaseResponse()
                .setCode(401L)
                .setStatus(401L)
                .setMessage(e.getMessage())
                .setView("二级认证异常！");
    }
}
