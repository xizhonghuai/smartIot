package com.server;

import org.springframework.stereotype.Component;

@Component
public class Fallback implements SayHiServer {

    @Override
    public String sayHi() {
        return err();
    }



    @Override
    public String sayErr() {
        return err();
    }

    @Override
    public String sayLoopback(String msg) {
        return err();
    }



    private String err(){
        return "服务不可用!";
    }
}
