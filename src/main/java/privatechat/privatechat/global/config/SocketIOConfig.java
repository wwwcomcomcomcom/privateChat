package privatechat.privatechat.global.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIOConfig {
    @Value("${netty-socketio.port}")
    private int port;
    @Value("${netty-socketio.host}")
    private String host;
    @Value("${netty-socketio.bossThreads}")
    private int bossThreads;
    @Value("${netty-socketio.workerThreads}")
    private int workerThreads;
    @Bean
    public SocketIOServer socketIOServer(){
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(port);
        config.setHostname(host);
        config.setBossThreads(bossThreads);
        config.setWorkerThreads(workerThreads);

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);

        config.setSocketConfig(socketConfig);

        return new SocketIOServer(config);
    }
}
