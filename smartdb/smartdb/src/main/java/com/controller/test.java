package com.controller;

import com.dbaccess.DBAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName test
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-05-08 09:44
 * @Version 1.0
 */
@Controller
public class test {




    @RequestMapping("/")
    public void home(HttpServletResponse response)throws Exception{
        response.sendRedirect("html/login.html");

    }



}
