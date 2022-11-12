package com.benjamin.service;

import com.benjamin.response.ResponseWithEntities;

import java.util.List;

public interface LoginService {

    /**
     * 用户对于权限
     * @param userName
     * @return
     */
    ResponseWithEntities<List<String>> queryPermissionsByUserName(String userName);
}
