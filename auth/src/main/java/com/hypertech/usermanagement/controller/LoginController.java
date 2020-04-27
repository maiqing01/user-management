package com.hypertech.usermanagement.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        System.out.println("来了老弟");
        return "login";
    }

    @RequestMapping("/")
    public String hello(HttpServletRequest request){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("当前登陆用户：" + name);
        return "hello";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin(){
        return "如果你看到这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_DBA')")
    public String printDBA(){
        return "如果你看到这句话，说明你有ROLE_DBA角色";
    }


}
