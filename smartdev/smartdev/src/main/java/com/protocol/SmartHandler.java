package com.protocol;


import com.alibaba.fastjson.JSON;
import com.common.SpringBeanUtils;
import com.common.TopiotService;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import com.entity.DeviceMsg;

import java.util.Date;

/**
 * @ClassName SmartHandler
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-07-12 14:34
 * @Version 1.0
 */
public class SmartHandler extends IoHandlerAdapter {
    private Logger logger = Logger.getLogger(SmartHandler.class);


    private boolean checkJsonString(String jsonStr) {
        try {
            DeviceMsg deviceMsg = JSON.parseObject(jsonStr, DeviceMsg.class);
            return true;
        } catch (Exception e) {

            return false;
        }


    }


    public void messageReceived(IoSession session, Object message) {
        String cache = (String) session.getAttribute("cache", "");
        String msg = message.toString();

        logger.info("收到数据：" + msg);

        if (msg.contains("{\"deviceId\"")){
            session.setAttribute("cache", "");
        }else {
            msg = cache+msg;
        }


        if (checkJsonString(msg)==false) {

            if (msg.length()>1024){
                session.removeAttribute("cache");
                return;
            }
            session.setAttribute("cache", msg);
            return;
        }


        DeviceMsg deviceMsg = null;
        try {
            deviceMsg = JSON.parseObject(msg, DeviceMsg.class);

        } catch (Exception e) {
            logger.info("报文校验错误！");
            session.write("check Error");
            return;
        }

        if (deviceMsg == null) return;
        session.write(JSON.toJSONString(new DeviceMsg(deviceMsg.getDeviceId(), new Date(), deviceMsg.getMsgType())));

       SmartProcess smartProcess = (SmartProcess) (SpringBeanUtils.getBean("smartProcess"));
       smartProcess.controlMessage(session, deviceMsg);





    }


    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        // Empty handler

        session.close();
    }

    public void sessionOpened(IoSession session) throws Exception {
        // Empty handler
        logger.info(session.getRemoteAddress() + "连接");
    }

    public void sessionClosed(IoSession session) throws Exception {
        // Empty handler
    }

}
