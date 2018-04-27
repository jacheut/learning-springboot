package com.xncoding.jwt.common;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.xncoding.jwt.handler.MessageEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * SpringBoot启动之后执行
 *
 */
@Component
@Order(1)
public class ServerRunner implements CommandLineRunner {
    private final SocketIOServer server;
    //自定义命名空间
    private final SocketIONamespace gameSocketNameSpace ;
    private static final Logger logger = LoggerFactory.getLogger(ServerRunner.class);

    @Autowired
    public ServerRunner(SocketIOServer server) {
        this.server = server;
        gameSocketNameSpace = server.addNamespace("/app")  ;
    }

    @Bean(name="gameNamespace")
    public SocketIONamespace getGameSocketIONameSpace(SocketIOServer server ){
        gameSocketNameSpace.addListeners(new MessageEventHandler(server));
        return gameSocketNameSpace  ;
    }

    @Override
    public void run(String... args) {
        logger.info("ServerRunner 开始启动啦...");
        server.start();
    }
}
