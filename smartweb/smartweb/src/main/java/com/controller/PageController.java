package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-18 11:32
 * @Version 1.0
 */

@Controller
public class PageController {

    @RequestMapping("/")
    public void home(HttpServletResponse response)throws Exception{
        response.sendRedirect("html/login.html");

    }




}
