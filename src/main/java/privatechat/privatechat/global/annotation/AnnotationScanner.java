package privatechat.privatechat.global.annotation;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
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
        Map<Object, List<Method>> result = new HashMap<>();
        Map<String, Object> socketControllers = scanSocketController();
        for(Object controller : socketControllers.values()){
            Class<?> controllerClass = controller.getClass();
            for(Method method : controllerClass.getMethods()){
                if(method.isAnnotationPresent(SocketMapping.class)){
                    Object bean = applicationContext.getBean(controllerClass);
                    log.info(method.getAnnotation(SocketMapping.class).value());
                    server.addEventListener(
                            method.getAnnotation(SocketMapping.class).value(),
                            method.getParameterTypes()[1],
                            (socketIOClient, o, ackRequest) -> {
                                System.out.println(o);
                                try{
                                    if (method.getParameterCount() == 2) {
                                        method.invoke(bean,socketIOClient, o);
                                    } else if (method.getParameterCount() == 3) {
                                        method.invoke(bean,socketIOClient, o, ackRequest);
                                    } else {
                                        log.error("Method {} has too many parameters: {}", method.getName(), method.getParameterCount());
                                    }
                                } catch (InvocationTargetException innerError){
                                    if(innerError.getTargetException() instanceof Exception){
                                        throw (Exception) innerError.getTargetException();
                                    } else {
                                        log.error("Exception occurred while invoking method: {}", method.getName(), innerError);
                                    }
                                }
                            });
                }
            }
        }
    }
}
