package com.dbaccess;

import com.entity.*;

/**
 * @ClassName DBAService
 * @Description TODO 数据访问接口
 * @Author xizhonghuai
 * @Date 2019-04-30 11:23
 * @Version 1.0
 */
public interface DBAService {

    /*
     * @Author xizhonghuai
     * @Description //TODO 添加设备
     * @Date  2019-04-30
     * @Param [deviceData]
     * @return com.entity.Response
     */
    Response addDeviceBasicsInfo(DeviceData deviceData);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 删除设备
     * @Date 2019-04-30
     * @Param [deviceData]
     */
    Response deleteDeviceBasicsInfo(DeviceData deviceData);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 更新设备
     * @Date 2019-04-30
     * @Param [deviceData]
     */
    Response updateDeviceBasicsInfo(DeviceData deviceData);


    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 获取设备基础信息
     * @Date 2019-04-30
     * @Param [deviceData, paging]
     */
    Response getDeviceBasicsInfo(DeviceData deviceData, Paging paging);


    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 更新实时数据
     * @Date 2019-04-30
     * @Param [deviceData, paging]
     */
    Response updateDeviceRealTimeData(DeviceData deviceData);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 获取设备实时数据
     * @Date 2019-04-30
     * @Param [deviceData, paging]
     */
    Response getDeviceRealTimeData(DeviceData deviceData,Paging paging);
    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 获取设备历史数据
     * @Date 2019-04-30
     * @Param [deviceData, paging]
     */
    Response getDeviceHistoryData(DeviceData deviceData, Paging paging);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 添加传感器
     * @Date 2019-04-30
     * @Param [sensorBind]
     */
    Response addSensor(SensorBind sensorBind);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 删除传感器
     * @Date 2019-04-30
     * @Param [sensorBind]
     */
    Response deleteSensor(SensorBind sensorBind);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 获取传感器绑定关系
     * @Date 2019-04-30
     * @Param [sensorBind, paging]
     */
    Response getSensor(SensorBind sensorBind, Paging paging);

    /*
     * @Author xizhonghuai
     * @Description //修改传感器配置信息 
     * @Date  2019-06-24 
     * @Param [sensorBind]
     * @return com.entity.Response 
    */
    Response updateSensor(SensorBind sensorBind);
    
    

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 添加摄像头
     * @Date 2019-04-30
     * @Param [cameraBind]
     */
    Response addCamera(CameraBind cameraBind);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 删除摄像头
     * @Date 2019-04-30
     * @Param [cameraBind]
     */
    Response deleteCamera(CameraBind cameraBind);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 获取摄像头绑定关系
     * @Date 2019-04-30
     * @Param [cameraBind, paging]
     */
    Response getCamera(CameraBind cameraBind, Paging paging);


    /*
     * @Author xizhonghuai
     * @Description //TODO 更新摄像头信息 
     * @Date  2019-06-25 
     * @Param [cameraBind]
     * @return com.entity.Response 
    */
    Response updateCamera(CameraBind cameraBind);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 获取城市区域信息
     * @Date 2019-04-30
     * @Param [cityArea, paging]
     */
    Response getCityArea(CityArea cityArea, Paging paging);

    /*
     * @Author xizhonghuai
     * @Description //TODO
     * @Date  2019-06-17
     * @Param [city]
     * @return com.entity.Response
     */
    Response getCity(City city);

    /*
     * @Author xizhonghuai
     * @Description //TODO
     * @Date  2019-06-17
     * @Param [area]
     * @return com.entity.Response
     */
    Response getArea(Area area);


    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 新增用户
     * @Date 2019-04-30
     * @Param [user]
     */
    Response addUser(User user);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 删除用户
     * @Date 2019-04-30
     * @Param [user]
     */
    Response deleteUser(User user);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 更新用户
     * @Date 2019-04-30
     * @Param [user]
     */
    Response updateUser(User user);

    /**
     * @return com.entity.Response
     * @Author xizhonghuai
     * @Description //TODO 查询用户
     * @Date 2019-04-30
     * @Param [user, paging]
     */
    Response getUser(User user, Paging paging);

    /*
     * @Author xizhonghuai
     * @Description //TODO 设备权限设置
     * @Date  2019-06-19
     * @Param [deviceAuthen]
     * @return com.entity.Response
    */
    Response deviceAuthorize(DeviceAuthen deviceAuthen);


}
