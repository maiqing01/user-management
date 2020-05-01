package cn.zhangxd.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public void index(HttpServletResponse response){
        response.setStatus(200);
    }

}
