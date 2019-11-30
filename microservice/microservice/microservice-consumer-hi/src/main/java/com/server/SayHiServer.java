package com.server;


import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @ClassName SayHiServer
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 16:00
 * @Version 1.0
 */

/*
   ReflectiveFeign.java
 */


@FeignClient(value = "provide-hi",fallback = Fallback.class)
public interface SayHiServer {

    @RequestMapping("hi")
    public String sayHi();


    @RequestMapping("err")
    public String sayErr();


    @RequestMapping(value = "loopback")
    public String sayLoopback(@RequestParam("msg") String msg);




}
