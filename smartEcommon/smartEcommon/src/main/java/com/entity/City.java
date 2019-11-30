package com.entity;

import java.io.Serializable;

/**
 * @ClassName City
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-17 15:52
 * @Version 1.0
 */
public class City implements Serializable {

    private Integer id;
    private String cityName;

    public City() {
    }

    public City(Integer id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
