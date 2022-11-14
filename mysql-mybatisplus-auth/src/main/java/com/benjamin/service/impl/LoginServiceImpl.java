package com.benjamin.service.impl;

import com.benjamin.dao.SysPermissionMapper;
import com.benjamin.dao.SysRoleMapper;
import com.benjamin.dao.SysUserMapper;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;



    /**
     * 用户对于权限
     * @param userName
     * @return
     */
    @Override
    public ResponseWithEntities<List<String>> queryPermissionsByUserName(String userName) {
        List<String> permissionList = sysUserMapper.queryPermissionsByUserName(userName);
        return new ResponseWithEntities<List<String>>().setData(permissionList);
    }
}
