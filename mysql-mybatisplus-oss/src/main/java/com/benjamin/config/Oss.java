package com.benjamin.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Component
@Accessors(chain = true)
public class Oss {

    private String endpoint;
}
