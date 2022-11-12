package com.benjamin.controller;

import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    private LoginService loginService;



    @GetMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password) {

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            return "登录成功";
        } catch (UnknownAccountException exception) {
            log.info( exception.getMessage() + "用户不存在");
            return "用户不存在";
        } catch (IncorrectCredentialsException exception) {
            log.info( exception.getMessage() + "密码错误");
            return "密码错误";
        }
    }

    /**
     * 用户对于权限
     * @param userName
     * @return
     */
    @GetMapping("/permissions/{userName}")
    public ResponseWithEntities<List<String>> queryPermissionsByUserName(@PathVariable("userName") String userName) {
        return loginService.queryPermissionsByUserName(userName);
    }
}
