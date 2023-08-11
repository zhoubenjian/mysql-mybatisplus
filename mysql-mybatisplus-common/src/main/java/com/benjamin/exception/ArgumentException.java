package com.benjamin.exception;

import lombok.Getter;

@Getter
public class ArgumentException extends RuntimeException {

    private final String argumentName;

    private final String desc;

    private final int code;



    public ArgumentException(String message, String argumentName, String desc, int code) {
        super(message);
        this.argumentName = argumentName;
        this.desc = desc;
        this.code = code;
    }
}
