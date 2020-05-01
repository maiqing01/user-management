package com.hypertech.usermanagement.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ===================================
 * 描 述 : 授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler
 * 包 名 : top.qinxq.single.common.auth
 * 创建人 : qinxq
 * ===================================
 */
@Component
public class AuthExceptionHandler extends OAuth2AccessDeniedHandler implements AuthenticationEntryPoint, AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException {
        CommonUtils.authException(request, response, authException,objectMapper);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        CommonUtils.authException(request, response, authException,objectMapper);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        CommonUtils.authException(request, response, authException,objectMapper);
    }
}
