package com.benjamin.sercice;

import com.benjamin.response.ResponseWithEntities;

public interface RabbitmqService {

    ResponseWithEntities<String> sendMessage(String message);
}
