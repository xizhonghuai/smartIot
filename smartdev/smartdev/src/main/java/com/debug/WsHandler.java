/**
 *
 */
package com.debug;

import com.common.Methods;
import com.common.SpringBeanUtils;
import com.common.TopiotService;
import com.mina.MinaSys;
import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XIZHONGHUAI
 */
@ServerEndpoint("/ws")
public class WsHandler {

    private Logger logger = Logger.getLogger(WsHandler.class);

    public static List<Session> websocketSession = new ArrayList<Session>();

    private Session session;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

        try {


            if (message.toString().length() <= 32) {
                return;
            }

            String header = message.toString().substring(0, 32);
            String serviceId = header.substring(0, 16).trim();
            String regId = header.substring(16).trim();
            String data = message.toString().substring(32);

            TopiotService ts = (TopiotService) SpringBeanUtils.getBean(serviceId);
            if (ts.isDebugflag()) {

                IoSession eqSSession = MinaSys.regIdToSession(ts.getManagedSessions(), regId);
                if (eqSSession != null) {
                    eqSSession.write(Methods.encodeGBK(data));
                } else {
                    session.getBasicRemote().sendText("error:" + regId + ",设备离线");
                }
            } else {
                session.getBasicRemote().sendText("error:" + serviceId + "未开启调试服务");
            }

        } catch (Exception e) {
            // TODO: handle exception
            session.getBasicRemote().sendText("error:" + e.toString());
            logger.info(e.toString());

        }

    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websocketSession.add(session);
    }

    @OnClose
    public void onClose() {
        websocketSession.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable error) {

        error.printStackTrace();
    }

    /**
     * Ⱥ����Ϣ���������
     *
     * @param message
     * @throws IOException
     */
    public static void sendMessage(String message) throws IOException {
        // Ⱥ����Ϣ
        for (int i = 0; i < websocketSession.size(); i++) {
            websocketSession.get(i).getBasicRemote().sendText(message);

        }
    }

}
