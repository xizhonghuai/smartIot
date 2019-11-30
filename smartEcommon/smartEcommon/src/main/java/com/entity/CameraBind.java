package com.entity;

import java.io.Serializable;
import java.lang.ref.SoftReference;

/**
 * @ClassName CameraBind
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-04-29 17:02
 * @Version 1.0
 */
public class CameraBind  implements Serializable {

    private Integer id;
    private String deviceId;
    private String cameraName;
    private String devUserName;
    private String devUserPassword;

    public CameraBind() {
    }

    public CameraBind(Integer id, String deviceId, String cameraName, String devUserName, String devUserPassword) {
        this.id = id;
        this.deviceId = deviceId;
        this.cameraName = cameraName;
        this.devUserName = devUserName;
        this.devUserPassword = devUserPassword;
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

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getDevUserName() {
        return devUserName;
    }

    public void setDevUserName(String devUserName) {
        this.devUserName = devUserName;
    }

    public String getDevUserPassword() {
        return devUserPassword;
    }

    public void setDevUserPassword(String devUserPassword) {
        this.devUserPassword = devUserPassword;
    }

    @Override
    public String toString() {

        

        return "CameraBind{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", devUserName='" + devUserName + '\'' +
                ", devUserPassword='" + devUserPassword + '\'' +
                '}';
    }
}
