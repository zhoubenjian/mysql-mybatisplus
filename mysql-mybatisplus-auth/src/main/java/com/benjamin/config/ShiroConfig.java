package com.benjamin.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加Shiro内置过滤器
        /**
         * anno:    无需授权即可访问
         * authc:   必须认证才能访问
         * user:    记住我才能访问
         * roles:   拥有对某个角色的权限才能访问
         * perms:   拥有对某个资源的权限才能访问
         */
        Map<String, Object> filterMap = new HashMap<>();
        // 授权

        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("sysUserRealm") SysUserRealm sysUserRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联sysUserRealm
        securityManager.setRealm(sysUserRealm);
        return securityManager;
    }

    @Bean
    public SysUserRealm sysUserRealm() {
        return new SysUserRealm();
    }
}
