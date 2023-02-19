package com.benjamin.config;

import com.benjamin.dao.SysUserMapper;
import com.benjamin.entities.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义UserReal
 */
public class SysUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserMapper sysUserMapper;



    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了 => 授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 拿到当前登录的对象
        Subject subject= SecurityUtils.getSubject();
        // 拿到User对象
        SysUser sysUser = (SysUser) subject.getPrincipal();

        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了 => 认证doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = sysUserMapper.querySysUserByUserName(userToken.getUsername());

        if (sysUser == null) {
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session=currentSubject.getSession();
        session.setAttribute("loginUser", sysUser);

        return new SimpleAuthenticationInfo(sysUser, userToken.getPassword(), "");
    }
}
