package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @ClassName BootApp
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-19 11:49
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaBootApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaBootApp.class,args);

    }
}
