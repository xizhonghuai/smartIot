package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dbaccess.DBAService;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName test
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-05-08 09:44
 * @Version 1.0
 */
@Controller
public class DataController {

    @Autowired
    private DBAService dbaService;

    //(HttpServletRequest request



    @RequestMapping(value = "/doLogin", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response doLogin(User user,HttpServletRequest request) {

       List<User> userList = (List<User>)dbaService.getUser(user,null).getResult();
       if (userList.size()<=0){
           return new Response(404,"用户名不存在");
       }

       User currentUser = userList.get(0);

       if (currentUser.getUserPassword().equals(user.getUserPassword())){

           currentUser.setUserPassword(null);

           currentUser.setKey(null);

           request.getSession().setAttribute("token", JSON.toJSONString(currentUser));


           return new Response();
       }


        return new Response(401,"密码错误");

    }




    @RequestMapping(value = "/getToken", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getToken(HttpServletRequest request) {

        String token = (String) request.getSession().getAttribute("token");

        return new Response(token);
    }






    @RequestMapping(value = "/getCity", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getCity(City city) {
        return dbaService.getCity(city);
    }

    @RequestMapping(value = "/getArea", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getArea(Area area) {
        return dbaService.getArea(area);
    }


    @RequestMapping(value = "/addDevice", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response addDevice(DeviceData deviceData) {
        List<Integer> userIds = JSONArray.parseArray(deviceData.getParams1().toString(), Integer.class);
        if (userIds != null) {
            DeviceAuthen deviceAuthen = new DeviceAuthen();
            deviceAuthen.setaType("add");
            deviceAuthen.setDeviceId(deviceData.getDeviceId());
            for (int i = 0, len = userIds.size(); i < len; i++) {
                deviceAuthen.setUserId(userIds.get(i));
                dbaService.deviceAuthorize(deviceAuthen);
            }
        }
        return dbaService.addDeviceBasicsInfo(deviceData);
    }

    @RequestMapping(value = "/getUser", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getUser(User user) {
        return dbaService.getUser(user, null);
    }

    @RequestMapping(value = "/addUser", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response addUser(User user) {

        List<User> users = (List<User>) dbaService.getUser(user, null).getResult();

        if (users.size() > 0) {

            return new Response(500, "该用户已存在");
        }

        user.setRegDate(new Date());

        return dbaService.addUser(user);
    }

    @RequestMapping(value = "/updateUser", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response updateUser(User user) {


        return dbaService.updateUser(user);
    }


    @RequestMapping(value = "/deviceAuthorize", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response deviceAuthorize(DeviceAuthen deviceAuthen) {
        return dbaService.deviceAuthorize(deviceAuthen);
    }


    @RequestMapping(value = "/deviceAutho", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response deviceAutho(DeviceData deviceData) {

        List<String> sqDevices = JSONArray.parseArray(deviceData.getParams1().toString(), String.class);
        if (sqDevices != null) {
            DeviceAuthen deviceAuthen = new DeviceAuthen();
            deviceAuthen.setaType("add");
            deviceAuthen.setUserId(deviceData.getUserId());
            for (int i = 0, len = sqDevices.size(); i < len; i++) {
                deviceAuthen.setDeviceId(sqDevices.get(i));
                dbaService.deviceAuthorize(deviceAuthen);
            }
        }


        List<String> notSqDevices = JSONArray.parseArray(deviceData.getParams2().toString(), String.class);
        if (notSqDevices != null) {
            DeviceAuthen deviceAuthen = new DeviceAuthen();
            deviceAuthen.setaType("delete");
            deviceAuthen.setUserId(deviceData.getUserId());
            for (int i = 0, len = notSqDevices.size(); i < len; i++) {
                deviceAuthen.setDeviceId(notSqDevices.get(i));
                dbaService.deviceAuthorize(deviceAuthen);
            }
        }

        return new Response();
    }


    @RequestMapping(value = "/getDeviceRealTimeData", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<DeviceData> getDeviceRealTimeData(DeviceData deviceData) {

        return (List<DeviceData>) dbaService.getDeviceRealTimeData(deviceData, null).getResult();
    }

    @RequestMapping(value = "/getDeviceBasicsInfo", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<DeviceData> getDeviceBasicsInfo(DeviceData deviceData) {

        return (List<DeviceData>) dbaService.getDeviceBasicsInfo(deviceData, null).getResult();
    }


    @RequestMapping(value = "/updateDeviceBasicsInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response updateDeviceBasicsInfo(DeviceData deviceData) {
        return dbaService.updateDeviceBasicsInfo(deviceData);
    }

    @RequestMapping(value = "/deleteDeviceBasicsInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response deleteDeviceBasicsInfo(DeviceData deviceData) {
        return dbaService.deleteDeviceBasicsInfo(deviceData);
    }

    @RequestMapping(value = "/getSensor", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SensorBind> getSensor(SensorBind sensorBind) {


        return (List<SensorBind>) dbaService.getSensor(sensorBind, null).getResult();
    }

    @RequestMapping(value = "/updateSensor", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response updateSensor(SensorBind sensorBind) {
        return dbaService.updateSensor(sensorBind);
    }

    @RequestMapping(value = "/addSensor", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response addSensor(SensorBind sensorBind) {

//        //判断是否重复添加
//        List<SensorBind> sensorBinds = getSensor(sensorBind);
//        if (sensorBinds.size() > 0) {
//            return new Response(500, "");
//        }


        return dbaService.addSensor(sensorBind);
    }

    @RequestMapping(value = "/deleteSensor", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response deleteSensor(SensorBind sensorBind) {
        return dbaService.deleteSensor(sensorBind);
    }


    @RequestMapping(value = "/getCamera", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<CameraBind> getCamera(CameraBind cameraBind) {
        return (List<CameraBind>) dbaService.getCamera(cameraBind, null).getResult();

    }

    @RequestMapping(value = "/updateCamera", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response updateCamera(CameraBind cameraBind) {
        return dbaService.updateCamera(cameraBind);
    }

    @RequestMapping(value = "/deleteCamera", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response deleteCamera(CameraBind cameraBind) {
        return dbaService.deleteCamera(cameraBind);
    }

    @RequestMapping(value = "/addCamera", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response addCamera(CameraBind cameraBind) {

        System.out.println(cameraBind.toString());
        return dbaService.addCamera(cameraBind);


    }


}
