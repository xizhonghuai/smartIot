package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassName ProvideHiBootApp
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 11:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ProvideHiBootApp {

    public static void main(String[] args) {
        SpringApplication.run(ProvideHiBootApp.class,args);
    }
}
