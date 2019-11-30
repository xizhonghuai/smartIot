package com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName DeviceData
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-04-29 17:00
 * @Version 1.0
 */
public class DeviceData implements Serializable {

    private Integer id;
    private String deviceId;
    private String deviceName;
    private Integer areaId;
    private String dtuId;
    private String company;
    private String mangerTel;
    private String address;
    private String longitude;
    private String latitude;
    private String remark;
    private Date regDate;

    private Integer cityId;
    private String cityName;
    private String areaName;

    private Integer userId;
    private String key;

    private String sensorField;
    private String propertyName;
    private Boolean sensorStatus;
    private Float valueAsNumber;
    private String valueAsText;
    private String warnmsg;
    private String unit;
    private Float warnY;
    private Float warnR;
    private Date cyDate;



    private Object params1;
    private Object params2;




    public DeviceData() {
    }

    public DeviceData(Integer id, String deviceId, String deviceName, Integer areaId, String dtuId, String company, String mangerTel, String address, String longitude, String latitude, String remark, Date regDate, Integer cityId, String cityName, String areaName, Integer userId, String key, String sensorField, String propertyName, Boolean sensorStatus, Float valueAsNumber, String valueAsText, String warnmsg, String unit, Float warnY, Float warnR, Date cyDate, Object params1, Object params2) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.areaId = areaId;
        this.dtuId = dtuId;
        this.company = company;
        this.mangerTel = mangerTel;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.remark = remark;
        this.regDate = regDate;
        this.cityId = cityId;
        this.cityName = cityName;
        this.areaName = areaName;
        this.userId = userId;
        this.key = key;
        this.sensorField = sensorField;
        this.propertyName = propertyName;
        this.sensorStatus = sensorStatus;
        this.valueAsNumber = valueAsNumber;
        this.valueAsText = valueAsText;
        this.warnmsg = warnmsg;
        this.unit = unit;
        this.warnY = warnY;
        this.warnR = warnR;
        this.cyDate = cyDate;
        this.params1 = params1;
        this.params2 = params2;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getDtuId() {
        return dtuId;
    }

    public void setDtuId(String dtuId) {
        this.dtuId = dtuId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMangerTel() {
        return mangerTel;
    }

    public void setMangerTel(String mangerTel) {
        this.mangerTel = mangerTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSensorField() {
        return sensorField;
    }

    public void setSensorField(String sensorField) {
        this.sensorField = sensorField;
    }

    public Boolean getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(Boolean sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public Float getValueAsNumber() {
        return valueAsNumber;
    }

    public void setValueAsNumber(Float valueAsNumber) {
        this.valueAsNumber = valueAsNumber;
    }

    public String getValueAsText() {
        return valueAsText;
    }

    public void setValueAsText(String valueAsText) {
        this.valueAsText = valueAsText;
    }

    public String getWarnmsg() {
        return warnmsg;
    }

    public void setWarnmsg(String warnmsg) {
        this.warnmsg = warnmsg;
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

    public Date getCyDate() {
        return cyDate;
    }

    public void setCyDate(Date cyDate) {
        this.cyDate = cyDate;
    }

    public Object getParams1() {
        return params1;
    }

    public void setParams1(Object params1) {
        this.params1 = params1;
    }

    public Object getParams2() {
        return params2;
    }

    public void setParams2(Object params2) {
        this.params2 = params2;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


    @Override
    public String toString() {
        return "DeviceData{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", areaId=" + areaId +
                ", dtuId='" + dtuId + '\'' +
                ", company='" + company + '\'' +
                ", mangerTel='" + mangerTel + '\'' +
                ", address='" + address + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", remark='" + remark + '\'' +
                ", regDate=" + regDate +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", userId=" + userId +
                ", key='" + key + '\'' +
                ", sensorField='" + sensorField + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", sensorStatus=" + sensorStatus +
                ", valueAsNumber=" + valueAsNumber +
                ", valueAsText='" + valueAsText + '\'' +
                ", warnmsg='" + warnmsg + '\'' +
                ", unit='" + unit + '\'' +
                ", warnY=" + warnY +
                ", warnR=" + warnR +
                ", cyDate=" + cyDate +
                ", params1=" + params1 +
                ", params2=" + params2 +
                '}';
    }
}
