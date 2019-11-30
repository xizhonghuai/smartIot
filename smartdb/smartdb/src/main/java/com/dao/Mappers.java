package com.dao;

import com.dbaccess.DBAService;
import com.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName Mappers
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-17 15:37
 * @Version 1.0
 */

@Repository
public interface Mappers {

    List<City> getCity(City city);

    List<Area> getArea(Area area);

    void addDeviceBasicsInfo(DeviceData deviceData);

    void addDeviceAuthorize(DeviceAuthen deviceAuthen);

    void deleteDeviceAuthorize(DeviceAuthen deviceAuthen);

    List<User> getUser(User user);
    void addUser(User user);
    void updateUser(User user);

    List<DeviceData> getDeviceRealTimeData(DeviceData deviceData);

    List<DeviceData> getDeviceHistoryData(DeviceData deviceData);

    List<DeviceData> getDeviceBasicsInfo(DeviceData deviceData);

    void updateDeviceBasicsInfo(DeviceData deviceData);

    void deleteDeviceBasicsInfo(DeviceData deviceData);

    List<SensorBind> getSensorBind(SensorBind sensorBind);
    void updateSensorBind(SensorBind sensorBind);
    void deleteSensorBind(SensorBind sensorBind);
    void addSensorBind(SensorBind sensorBind);

    List<CameraBind> getCameraBind(CameraBind cameraBind);
//    void updateCameraBind(CameraBind cameraBind);
    void deleteCameraBind(CameraBind cameraBind);
    void addCameraBind(CameraBind cameraBind);

    void updateDeviceRealTimeData(DeviceData deviceData);








}
