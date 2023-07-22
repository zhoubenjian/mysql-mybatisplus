package com.benjamin.aop;

import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 自定义异常加入全局异常处理器
     *
     * @param webException
     * @return
     */
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

    /**
     * 参数异常加入全局异常处理器（@Valid）
     *
     * @param e 异常（单独拦截参数校验的三个异常：javax.validation.ConstraintViolationException，org.springframework.validation.BindException，org.springframework.web.bind.MethodArgumentNotValidException）
     * @return
     */
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public BaseResponse handleValidatedException(Exception e) {
        log.error("@Vaild异常捕获...");

        BaseResponse baseResponse = new BaseResponse();
        if (e instanceof MethodArgumentNotValidException) {

            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            baseResponse.setCode((long) HttpStatus.BAD_REQUEST.value())
                    .setStatus((long) HttpStatus.BAD_REQUEST.value())
                    .setMessage(ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; ")))
                    .setView(ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; ")));
            
        } else if (e instanceof ConstraintViolationException) {

            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            baseResponse.setCode((long) HttpStatus.BAD_REQUEST.value())
                    .setStatus((long) HttpStatus.BAD_REQUEST.value())
                    .setMessage(ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; ")))
                    .setView(ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; ")));
            
        } else if (e instanceof BindException) {

            // BeanValidation GET object param
            BindException ex = (BindException) e;
            baseResponse.setCode((long) HttpStatus.BAD_REQUEST.value())
                    .setStatus((long) HttpStatus.BAD_REQUEST.value())
                    .setMessage(ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; ")))
                    .setView(ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; ")));

        } else {

            baseResponse.setCode((long) HttpStatus.BAD_REQUEST.value())
                    .setStatus((long) HttpStatus.BAD_REQUEST.value())
                    .setMessage("参数异常")
                    .setView("参数异常");
        }

        return baseResponse;
    }
}
