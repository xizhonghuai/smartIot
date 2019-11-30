package com.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AccessInterceptor
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-18 13:04
 * @Version 1.0
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURL().toString();

        String token = (String) request.getSession().getAttribute("token");

        if (url.contains("doLogin")){
            return true;
        }

        if (url.contains("login")){
            return true;
        }

        if (token == null){



            return false;
        }

        return true;
    }
}
