package com.benjamin.exception;

import com.benjamin.error.SystemErrors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class WebException extends RuntimeException {

    private SystemErrors systemErrors;



    public SystemErrors getSystemErrorEnum() {
        return systemErrors;
    }

    public void setSystemErrorEnum(SystemErrors systemErrors) {
        this.systemErrors = systemErrors;
    }



//    private final Long code;
//    private final String view;
//    private final Long status;
//
//
//
//    public WebException(String message, Long code, String view) {
//        super(message);
//        this.code = code;
//        this.view = view;
//        this.status = code;
//    }
//
//    public WebException(String message, Long code, String view, Throwable throwable) {
//        super(message, throwable);
//        this.code = code;
//        this.view = view;
//        this.status = code;
//    }
//
//    public WebException(String message, Long code, String view, Long status) {
//        super(message);
//        this.code = code;
//        this.view = view;
//        this.status = status;
//    }
//
//    public WebException(String message, Long code, String view, Long status, Throwable throwable) {
//        super(message, throwable);
//        this.code = code;
//        this.view = view;
//        this.status = status;
//    }
//
//    public Long getCode() {
//        return this.code;
//    }
//
//    public String getView() {
//        return this.view;
//    }
//
//    public Long getStatus() {
//        return this.status;
//    }
}
