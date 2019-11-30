package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName Application
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-07-11 15:23
 * @Version 1.0
 */

@SpringBootApplication
@ImportResource(locations = {"classpath:smart.xml"})
public class ApplicationBoot {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationBoot.class,args);
    }

}
