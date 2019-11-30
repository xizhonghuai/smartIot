package com;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {



    @Autowired
    ApplicationContext ioc;

    @GetMapping("/test")
    @ResponseBody
    public User test(){
        return   (User) ioc.getBean("user");
    }
}
