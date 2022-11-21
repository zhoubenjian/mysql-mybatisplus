package com.benjamin.aop;

import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(WebException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(WebException webException) {
        SystemErrors se = webException.getSystemErrorEnum();
        return new BaseResponse()
                .setCode(se.getCode())
                .setStatus(se.getStatus())
                .setMessage(se.getMessage())
                .setView(se.getView());
    }
}
