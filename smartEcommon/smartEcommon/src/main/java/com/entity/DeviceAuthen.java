package com.entity;

import java.io.Serializable;

/**
 * @ClassName DeviceAuthen
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-19 10:44
 * @Version 1.0
 */
public class DeviceAuthen implements Serializable {

    private Integer id;
    private String deviceId;
    private Integer userId;
    private String aType;

    public DeviceAuthen() {
    }

    public DeviceAuthen(Integer id, String deviceId, Integer userId, String aType) {
        this.id = id;
        this.deviceId = deviceId;
        this.userId = userId;
        this.aType = aType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    @Override
    public String toString() {
        return "DeviceAuthen{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", userId=" + userId +
                ", aType='" + aType + '\'' +
                '}';
    }
}
