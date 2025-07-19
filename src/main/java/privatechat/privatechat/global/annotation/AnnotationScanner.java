package privatechat.privatechat.global.annotation;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnnotationScanner  {
    private final ApplicationContext applicationContext;
    private final SocketIOServer server;

    private Map<String, Object> scanSocketController() {
        return applicationContext.getBeansWithAnnotation(SocketListener.class);
    }
    public void registerSocketMapping(){
        Map<String, Object> socketControllers = scanSocketController();
        for(Object controller : socketControllers.values()){
            server.addListeners(controller);
        }
    }
}
