package com.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName DeviceMsg
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-14 13:23
 * @Version 1.0
 */
public class DeviceMsg {

    private String deviceId;
    private Date date;
    private Integer msgType;
    private HashMap<String,Object> sensorData;
    private HashMap<String,Object> writeSensorConfig;
    private String[] sensorException;
    private String[] dataSelect;
    private String[] readSensorConfig;
    private HashMap<String,Object> writeRtuConfig;
    private String[] readRtuConfig;

    public DeviceMsg() {
    }

    public DeviceMsg(String deviceId, Date date, Integer msgType) {
        this.deviceId = deviceId;
        this.date = date;
        this.msgType = msgType;
    }

    public DeviceMsg(String deviceId, Date date, Integer msgType, HashMap<String, Object> sensorData, HashMap<String, Object> writeSensorConfig, String[] sensorException, String[] dataSelect, String[] readSensorConfig, HashMap<String, Object> writeRtuConfig, String[] readRtuConfig) {
        this.deviceId = deviceId;
        this.date = date;
        this.msgType = msgType;
        this.sensorData = sensorData;
        this.writeSensorConfig = writeSensorConfig;
        this.sensorException = sensorException;
        this.dataSelect = dataSelect;
        this.readSensorConfig = readSensorConfig;
        this.writeRtuConfig = writeRtuConfig;
        this.readRtuConfig = readRtuConfig;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public HashMap<String, Object> getSensorData() {
        return sensorData;
    }

    public void setSensorData(HashMap<String, Object> sensorData) {
        this.sensorData = sensorData;
    }

    public HashMap<String, Object> getWriteSensorConfig() {
        return writeSensorConfig;
    }

    public void setWriteSensorConfig(HashMap<String, Object> writeSensorConfig) {
        this.writeSensorConfig = writeSensorConfig;
    }

    public String[] getSensorException() {
        return sensorException;
    }

    public void setSensorException(String[] sensorException) {
        this.sensorException = sensorException;
    }

    public String[] getDataSelect() {
        return dataSelect;
    }

    public void setDataSelect(String[] dataSelect) {
        this.dataSelect = dataSelect;
    }

    public String[] getReadSensorConfig() {
        return readSensorConfig;
    }

    public void setReadSensorConfig(String[] readSensorConfig) {
        this.readSensorConfig = readSensorConfig;
    }

    public HashMap<String, Object> getWriteRtuConfig() {
        return writeRtuConfig;
    }

    public void setWriteRtuConfig(HashMap<String, Object> writeRtuConfig) {
        this.writeRtuConfig = writeRtuConfig;
    }

    public String[] getReadRtuConfig() {
        return readRtuConfig;
    }

    public void setReadRtuConfig(String[] readRtuConfig) {
        this.readRtuConfig = readRtuConfig;
    }

    @Override
    public String toString() {
        return "DeviceMsg{" +
                "deviceId='" + deviceId + '\'' +
                ", date=" + date +
                ", msgType=" + msgType +
                ", sensorData=" + sensorData +
                ", writeSensorConfig=" + writeSensorConfig +
                ", sensorException=" + Arrays.toString(sensorException) +
                ", dataSelect=" + Arrays.toString(dataSelect) +
                ", readSensorConfig=" + Arrays.toString(readSensorConfig) +
                ", writeRtuConfig=" + writeRtuConfig +
                ", readRtuConfig=" + Arrays.toString(readRtuConfig) +
                '}';
    }
}
