package privatechat.privatechat.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ApiResponse<T> {

    HttpStatus status;
    int code;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;

    public ApiResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.code = status.value();
        this.message = message;
        this.data = data;
    }

    public ApiResponse(HttpStatus status, T data) {
        this.status = status;
        this.code = status.value();
        this.message = status.getReasonPhrase();
        this.data = data;
    }

    public static <T> ApiResponse<T> of(HttpStatus status, String message, T data) {
        return new ApiResponse<>(status, message, data);
    }

    public static ApiResponse success(@Nonnull String message) {
        return new ApiResponse(HttpStatus.OK, message, null);
    }

    public static ApiResponse created(@Nonnull String message) {
        return new ApiResponse(HttpStatus.CREATED, message, null);
    }

    public static ApiResponse error(@Nonnull String message, @Nonnull HttpStatus status) {
        return new ApiResponse(status, message, null);
    }
}
