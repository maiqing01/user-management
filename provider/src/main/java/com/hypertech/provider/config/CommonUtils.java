package com.hypertech.provider.config;

import cn.mq.result.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ===================================
 * 描 述 : 公共工具类
 * 包 名 : top.qinxq.single.common.utils
 * 创建人 : qinxq
 * ===================================
 */
public class CommonUtils {
    /**
     * =====================================
     * 描   述 : Auth2.0 异常封装
     * 参   数 :  [request, response, authException, objectMapper]
     * 返 回 值 : void
     * 创 建 人 :  qinxq
     * =====================================
     */
    public static void authException (HttpServletRequest request, HttpServletResponse response, Exception authException, ObjectMapper objectMapper) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ResponseData<String> result = new ResponseData("1001","认证失败，禁止访问");
        response.setStatus(HttpStatus.OK.value());
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(result));
    }
}
