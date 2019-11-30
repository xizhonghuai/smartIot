package com.entity;

import java.io.Serializable;

/**
 * @ClassName SensorBind
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-04-29 17:02
 * @Version 1.0
 */
public class SensorBind implements Serializable {

    private Integer id;
    private String deviceId;
    private String sensorField;
    private String propertyName;
    private String unit;
    private Float warnY;
    private Float warnR;

    public SensorBind() {
    }

    public SensorBind(String deviceId) {
        this.deviceId = deviceId;
    }

    public SensorBind(Integer id, String deviceId, String sensorField, String propertyName, String unit, Float warnY, Float warnR) {
        this.id = id;
        this.deviceId = deviceId;
        this.sensorField = sensorField;
        this.propertyName = propertyName;
        this.unit = unit;
        this.warnY = warnY;
        this.warnR = warnR;
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

    public String getSensorField() {
        return sensorField;
    }

    public void setSensorField(String sensorField) {
        this.sensorField = sensorField;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getWarnY() {
        return warnY;
    }

    public void setWarnY(Float warnY) {
        this.warnY = warnY;
    }

    public Float getWarnR() {
        return warnR;
    }

    public void setWarnR(Float warnR) {
        this.warnR = warnR;
    }

    @Override
    public String toString() {
        return "SensorBind{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", sensorField='" + sensorField + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", unit='" + unit + '\'' +
                ", warnY=" + warnY +
                ", warnR=" + warnR +
                '}';
    }
}





