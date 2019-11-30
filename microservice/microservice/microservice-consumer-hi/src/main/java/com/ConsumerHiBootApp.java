package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ProvideHiBootApp
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 11:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerHiBootApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHiBootApp.class,args);
    }
}
