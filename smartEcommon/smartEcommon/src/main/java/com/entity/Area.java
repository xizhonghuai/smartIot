package com.entity;

import java.io.Serializable;

/**
 * @ClassName Area
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-17 15:53
 * @Version 1.0
 */
public class Area implements Serializable {

    private Integer id;
    private Integer cityId;
    private String areaName;

    public Area() {
    }

    public Area(Integer id, Integer cityId, String areaName) {
        this.id = id;
        this.cityId = cityId;
        this.areaName = areaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "Id=" + id +
                ", cityId=" + cityId +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
