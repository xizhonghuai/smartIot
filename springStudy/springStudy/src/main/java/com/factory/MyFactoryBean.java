package com.factory;

import com.beans.User;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<User> {


    private  String args;

    public User getObject() throws Exception {

        String[] args = this.args.split(",");

        return new User(args[0],Integer.parseInt(args[1]),args[2],args[3]);

    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }
}
