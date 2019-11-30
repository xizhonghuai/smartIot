package com.protocol;

import com.alibaba.fastjson.JSON;
import com.common.SpringBeanUtils;
import com.common.TopiotService;
import com.dbaccess.DBAService;
import com.entity.DeviceData;
import com.transportlayer.MyClient;
import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.entity.DeviceMsg;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * @ClassName SmartProcess
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-07-12 14:50
 * @Version 1.0
 */

@Component("smartProcess")
public class SmartProcess {

   // @Resource(name = "DBAService")
  @Autowired
//    @Qualifier(value = "dBAService")
    private DBAService dbaService;

    private Logger logger = Logger.getLogger(SmartProcess.class);


    public void controlMessage(IoSession session, DeviceMsg deviceMsg) {

        DeviceMsg currentDeviceMsg = deviceMsg;
        session.setAttribute("regId", currentDeviceMsg.getDeviceId());


        if (deviceMsg.getDeviceId().equals("00000001") || deviceMsg.getDeviceId().equals("00000002")){


            try {

                MyClient myClient = (MyClient) SpringBeanUtils.getBean("eq");

                if (myClient.getStatus()) {
                    myClient.getSession().write(JSON.toJSONString(deviceMsg));
                } else {
                    myClient.start();
                }
            } catch (Exception e){

                //

            }


        }



        if (currentDeviceMsg.getSensorData() != null) {

            HashMap<String, Object> sensorDataMap = currentDeviceMsg.getSensorData();

            Object sensorException = currentDeviceMsg.getSensorException();


            for (Entry<String, Object> entry : sensorDataMap.entrySet()) {

                DeviceData deviceData = new DeviceData();
                deviceData.setDeviceId(currentDeviceMsg.getDeviceId());
                deviceData.setSensorField(entry.getKey());
                deviceData.setValueAsNumber(Float.parseFloat(entry.getValue().toString()));
                deviceData.setCyDate(currentDeviceMsg.getDate());
                deviceData.setSensorStatus(true);
                if (sensorException !=null){

                    String e = JSON.toJSONString(sensorException);

                    if (e.contains(deviceData.getSensorField())){
                        deviceData.setSensorStatus(false);
                    }
                }


                try {

                    dbaService.updateDeviceRealTimeData(deviceData);

                } catch (Exception e) {
                    logger.info("异常:" + e.toString());
                }
            }
        }

    }


}
