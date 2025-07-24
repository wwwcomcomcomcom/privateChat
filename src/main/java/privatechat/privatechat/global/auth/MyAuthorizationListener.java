package privatechat.privatechat.global.auth;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.AuthorizationResult;
import com.corundumstudio.socketio.HandshakeData;
import io.netty.handler.codec.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class MyAuthorizationListener implements AuthorizationListener {
    @Override
    public AuthorizationResult getAuthorizationResult(HandshakeData data) {
        HttpHeaders httpHeaders = data.getHttpHeaders();
        String authHeader = httpHeaders.get("Authorization");
        return null;
    }
}
