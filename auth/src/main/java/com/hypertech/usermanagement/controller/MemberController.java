package com.hypertech.usermanagement.controller;

import cn.mq.result.ResponseData;
import cn.mq.result.ResponseDataUtil;
import com.hypertech.usermanagement.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    public Principal user(Principal member){
        return member;
    }

    @DeleteMapping(value = "/exit")
    public ResponseData revokeToken(String access_token){
        if(consumerTokenServices.revokeToken(access_token)){
            return ResponseDataUtil.success("注销成功");
        }else{
            return ResponseDataUtil.system_error("注销失败");
        }
    }

}
