package privatechat.privatechat.domain.user.dto.req;

import privatechat.privatechat.global.annotation.validation.CustomEmailValidator;

public record UserCreateReqDto(
    String name,
    String password,
    @CustomEmailValidator
    String email
) {
}
