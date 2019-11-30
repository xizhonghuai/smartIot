package com;


import com.sun.deploy.appcontext.AppContext;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class test {

    @Value("${beanPath}")
    private String beanPath;


    @PostConstruct
    public void start() {

        new FileSystemXmlApplicationContext(beanPath);

        System.out.print("启动"+beanPath);


    }








    }
