package com.controller;


import com.server.SayHiServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName TestController
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 15:18
 * @Version 1.0
 */
@RestController
public class TestController {


    @Autowired
    private SayHiServer sayHiServer;


    @RequestMapping("hi")
    public String sayHi(){

        return sayHiServer.sayHi();
    }



    @RequestMapping("err")
    public String sayErr() {
        return sayHiServer.sayErr();
    }


    @RequestMapping(value = "loopback")
    public String sayLoopback(String msg) {


        return sayHiServer.sayLoopback(msg);
    }


}
