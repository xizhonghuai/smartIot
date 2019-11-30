package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dbaccess.DBAService;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.*;

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


    @RequestMapping(value = "/getUser", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response getUser(User user) {
        return dbaService.getUser(user, null);
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


    @RequestMapping(value = "/getDeviceHistoryData", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<DeviceData> getDeviceHistoryData(DeviceData deviceData) {



        return (List<DeviceData>) dbaService.getDeviceHistoryData(deviceData, null).getResult();
    }


    @RequestMapping(value = "/getSensor", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SensorBind> getSensor(SensorBind sensorBind) {


        return (List<SensorBind>) dbaService.getSensor(sensorBind, null).getResult();
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




    @RequestMapping("/getCmdMessage")
    @ResponseBody
    public DeviceMsg getCmdMessage(String deviceId, Integer cmdId) {

        if (cmdId == 0) {

            DeviceMsg deviceMsg = new DeviceMsg(deviceId, new Date(), 3);
            List<SensorBind> sensorBindList = (List<SensorBind>) dbaService.getSensor(new SensorBind(deviceId), null).getResult();

            String[] dataSelect = new String[sensorBindList.size()];
            for (int i = 0, len = sensorBindList.size(); i < len; i++) {
                dataSelect[i] = sensorBindList.get(i).getSensorField();
            }
            deviceMsg.setDataSelect (dataSelect);

            return deviceMsg;
        } else if (cmdId == 1) {

            DeviceMsg deviceMsg = new DeviceMsg(deviceId, new Date(), 5);
            List<SensorBind> sensorBindList = (List<SensorBind>) dbaService.getSensor(new SensorBind(deviceId), null).getResult();

            String[] readSensorConfig = new String[sensorBindList.size()];
            for (int i = 0, len = sensorBindList.size(); i < len; i++) {
                readSensorConfig[i] = sensorBindList.get(i).getSensorField();
            }
            deviceMsg.setReadSensorConfig(readSensorConfig);

            return deviceMsg;
        } else if (cmdId == 2) {

            DeviceMsg deviceMsg = new DeviceMsg(deviceId, new Date(), 4);
            List<SensorBind> sensorBindList = (List<SensorBind>) dbaService.getSensor(new SensorBind(deviceId), null).getResult();

            HashMap<String, Object> writeSensorConfig = new HashMap<String, Object>();


            for (int i = 0, len = sensorBindList.size(); i < len; i++) {
                writeSensorConfig.put(sensorBindList.get(i).getSensorField(),  new SensorParams(1, 2, 10));
            }
            deviceMsg.setWriteSensorConfig(writeSensorConfig);

            return deviceMsg;
        } else if (cmdId == 3) {
            DeviceMsg deviceMsg = new DeviceMsg(deviceId, new Date(), 8);
            String[] readRtuConfig = {"dataInterval", "heartInterval", "deviceId"};
            deviceMsg.setReadRtuConfig(readRtuConfig);
            return deviceMsg;
        } else if (cmdId == 4) {
            DeviceMsg deviceMsg = new DeviceMsg(deviceId, new Date(), 7);

            HashMap<String,Object> writeRtuConfig = new HashMap<String,Object>();
            writeRtuConfig.put("dataInterval",30);
            writeRtuConfig.put("heartInterval",2);
            writeRtuConfig.put("deviceId",deviceId);
            deviceMsg.setWriteRtuConfig(writeRtuConfig);
            return deviceMsg;
        }

        return new DeviceMsg(deviceId, new Date(), 0);
    }



    private  String sendGet(String url, String param) {
        String result = "";

        BufferedReader in = null;



        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接

            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段

            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }




    @RequestMapping("/getImgs")
    @ResponseBody
    public Response getImgs(@RequestParam(value = "deviceId", required = false) String deviceId,
                            @RequestParam(value = "date", required = false) String date) {

        if (deviceId.equals("00000001")){deviceId = "CAMER";}

        String ret = sendGet("http://127.0.0.1:8083/smartIPC/data.api/getImgs","ipcName="+deviceId+"&date="+date);
        Response response = JSON.parseObject(ret, Response.class);

        return response;

    }


}
