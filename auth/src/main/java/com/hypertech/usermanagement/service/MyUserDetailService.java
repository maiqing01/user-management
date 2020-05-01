package com.hypertech.usermanagement.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        //角色必须是ROLE_开头，可以在数据库中设置
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        grantedAuthorities.add(grantedAuthority);
        //获取权限
        GrantedAuthority permission = new SimpleGrantedAuthority("/api/current");
        grantedAuthorities.add(permission);

        User user = new User(username,"abc",enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,grantedAuthorities);
        return user;

    }
}
