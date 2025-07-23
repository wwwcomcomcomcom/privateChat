package privatechat.privatechat.domain.chat.listener;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.stereotype.Component;
import privatechat.privatechat.global.annotation.SocketListener;

@SocketListener
@Component
public class ChatListener {
    @OnEvent("message")
    public void chatting(SocketIOClient client, String message){
        System.out.println(message);
    }
}
