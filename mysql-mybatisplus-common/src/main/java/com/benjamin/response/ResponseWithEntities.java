package com.benjamin.response;

import lombok.Data;

@Data
public class ResponseWithEntities<T> {
    private T data;
}
