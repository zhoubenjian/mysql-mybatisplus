package com.benjamin.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SignEnum {

    SIGN_IN(1),
    SIGN_OUT(2),
    ;



    private final int code;

    public int getCode() {
        return code;
    }
}
