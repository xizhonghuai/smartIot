package com.controller;


import com.dbaccess.DBAService;
import com.entity.DeviceData;
import com.entity.Response;
import com.entity.SensorBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/data.api")
public class DataApi {

    @Autowired
    private DBAService dbaService;


    @RequestMapping(value = "/getDeviceRealTimeData", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getDeviceRealTimeData(DeviceData deviceData) {

        return   dbaService.getDeviceRealTimeData(deviceData, null);
    }

    @RequestMapping(value = "/getDeviceBasicsInfo", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getDeviceBasicsInfo(DeviceData deviceData) {

        return   dbaService.getDeviceBasicsInfo(deviceData, null);
    }


    @RequestMapping(value = "/getSensor",   produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getSensor(SensorBind sensorBind) {


        return   dbaService.getSensor(sensorBind, null);
    }


    @RequestMapping(value = "/getDeviceHistoryData", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getDeviceHistoryData(DeviceData deviceData) {



        return  dbaService.getDeviceHistoryData(deviceData, null);
    }





}
