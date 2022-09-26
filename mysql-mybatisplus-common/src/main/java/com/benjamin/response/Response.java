package com.benjamin.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response {
    private Long code;
    private Long status;
    private String message;
    private String view;
    private Long timestamp;



    public Response() {
        this.code = 0L;
        this.status = 0L;
        this.message = "success";
        this.view = "success";
        this.timestamp = System.currentTimeMillis();
    }
}
