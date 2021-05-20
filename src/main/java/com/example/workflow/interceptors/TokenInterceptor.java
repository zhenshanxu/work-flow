package com.example.workflow.interceptors;

import com.alibaba.fastjson.JSONObject;
import com.example.workflow.config.JwtUtil;
import com.example.workflow.utils.CommonUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Administrator
 */

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JwtUtil jwtUtil = new JwtUtil();
        //token 校验
        String accessToken = request.getHeader("Authorization");
        if (accessToken == null) {
            errorMsg(0, response);
            return false;
        } else {
            try {
                //验证token是否过期
                Claims claims = jwtUtil.validateJWT(accessToken);
                Long expiration = claims.getExpiration().getTime();
                Long nowTime = System.currentTimeMillis();
                if ((nowTime - expiration) > CommonUtil.TOKEN_EXPIRE_TIME) {
                    errorMsg(1, response);
                    return false;
                } else {
                    return HandlerInterceptor.super.preHandle(request, response, handler);
                }
            } catch (Exception e) {
                errorMsg(0, response);
                return false;
            }
        }
    }

    /**
     * 错误信息提醒
     *
     * @param status   错误类型
     * @param response
     * @throws IOException
     */
    public void errorMsg(int status, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        res.put("success", false);
        if (status == 1) {
            res.put("errorMsg", "登录失效，请重新登录！");
        } else {
            res.put("errorMsg", "操作失败，请登录！");
        }
        PrintWriter out = null;
        out = response.getWriter();
        out.write(res.toString());
        out.flush();
        out.close();
    }
}
