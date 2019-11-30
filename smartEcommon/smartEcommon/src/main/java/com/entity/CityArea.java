package com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CityArea
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-04-29 17:05
 * @Version 1.0
 */
public class CityArea implements Serializable {


    private Integer Id;
    private Integer cityId;
    private String cityName;
    private String areaName;

    public CityArea() {
    }

    public CityArea(Integer id, Integer cityId, String cityName, String areaName) {
        Id = id;
        this.cityId = cityId;
        this.cityName = cityName;
        this.areaName = areaName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "CityArea{" +
                "Id=" + Id +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
