package com.controller;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 15:18
 * @Version 1.0
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("hi")
    public String sayHi() {
         return "from port :"+port+"  hello world " + new Date();
    }


    @RequestMapping("err")
    @HystrixCommand(fallbackMethod = "sayError")
    public String sayErr() {
        int k = 1/0;
        return null;
    }


    @RequestMapping(value = "loopback")
    @HystrixCommand(fallbackMethod = "sayError1")
    public String sayLoopback(String msg) {
        return msg+"  "+new Date();
    }



    public String sayError(){
       return "oh,Err";
    }

    public String sayError1(String msg){
        return "oh,Err";
    }




}
