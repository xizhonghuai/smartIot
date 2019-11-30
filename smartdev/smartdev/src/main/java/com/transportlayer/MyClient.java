package com.transportlayer;

import com.common.Methods;
import com.common.TopiotService;
import com.debug.DebugFilter;
import com.m2m.M2MFilter;
import com.mina.CodecFactory;
import com.protocol.SmartHandler;
import com.push.PushFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @ClassName MyClient
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-08-23 13:24
 * @Version 1.0
 */
public class MyClient implements TopiotService {

    private Logger logger = LoggerFactory.getLogger(MyClient.class);

    private IoConnector ioConnector;

    private ConnectFuture connectFuture;

    private boolean status = false;

    private String handler;

    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public boolean getStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean isDebugflag() {
        return false;
    }

    @Override
    public boolean isPushflag() {
        return false;
    }

    @Override
    public IoSession getSession() {
        return connectFuture.getSession();
    }

    @Override
    public String getPushUrl() {
        return null;
    }

    @Override
    public Map<Long, IoSession> getManagedSessions() {
        return null;
    }

    @PreDestroy
    @Override
    public void close() {

        ioConnector.dispose();
        ioConnector = null;
        status = false;
        logger.info("客户端断开" + port.toString() + "");

    }

    @PostConstruct
    public boolean start() {
        // TODO Auto-generated method stub

        try {



            ioConnector = new NioSocketConnector();
            ioConnector.setConnectTimeoutMillis(30000);

            ioConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(
                    new CodecFactory(Charset.forName("ISO-8859-1"), Charset.forName("ISO-8859-1"))));

            ioConnector.getSessionConfig().setMaxReadBufferSize(2048);

            ioConnector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 900);

            try {

                ioConnector.setHandler((IoHandler) Methods.getObjNewInstance(handler));

            } catch (Exception e) {
                // TODO: handle exception
                logger.info("绑定处理器异常" + e.getMessage());
            }


            connectFuture =  ioConnector.connect(new InetSocketAddress(host,port));

            connectFuture.awaitUninterruptibly();





            logger.info("连接服务器成功！" +host+"/"+port.toString());
            status = true;


            return true;

        } catch (Exception e) {
            // TODO: handle exception

            logger.info("连接服务器失败！" +host+"/"+port.toString());
            status = false;
            return false;
        }

    }


}
