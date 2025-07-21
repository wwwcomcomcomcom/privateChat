package privatechat.privatechat.domain.user.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserCreateReqDto(
    String name,
    String password,
    @Email(message = "유효하지 않은 이메일 형식입니다.",regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    @NotNull(message = "이메일은 필수 입력입니다.")
    String email
) {
}
