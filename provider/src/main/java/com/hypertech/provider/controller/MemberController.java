package com.hypertech.provider.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MemberController {

    @GetMapping("admin")
    /*@PreAuthorize("hasAnyAuthority('hello')")*/
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello(){
        return "hello";
    }

    @GetMapping("current")
    public Principal user(Principal principal) {

        return principal;
    }

    @GetMapping("user")
    /*@PreAuthorize("hasAnyAuthority('query')")*/
    @PreAuthorize("hasRole('ROLE_DBA')")
    public String query() {
        return "具有query权限";
    }


}
