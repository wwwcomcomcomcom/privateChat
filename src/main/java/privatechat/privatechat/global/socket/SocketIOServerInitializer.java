package privatechat.privatechat.global.socket;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;
import privatechat.privatechat.global.annotation.AnnotationScanner;

@Component
@RequiredArgsConstructor
public class SocketIOServerInitializer implements SmartInitializingSingleton {
    private final SocketIOServer server;
    private final AnnotationScanner scanner;

    @Override
    public void afterSingletonsInstantiated() {
        scanner.registerSocketMapping();
        server.start();
    }
}
