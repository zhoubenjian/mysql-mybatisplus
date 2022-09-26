package com.benjamin.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseWithEntities<T> extends Response {
    private T data;
}
