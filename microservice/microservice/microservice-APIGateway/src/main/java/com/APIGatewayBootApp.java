package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * @ClassName BootApp
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 11:49
 * @Version 1.0
 */

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class APIGatewayBootApp {

    public static void main(String[] args) {
        SpringApplication.run(APIGatewayBootApp.class,args);

    }
}
