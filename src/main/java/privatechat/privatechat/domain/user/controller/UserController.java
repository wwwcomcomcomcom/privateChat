package privatechat.privatechat.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import privatechat.privatechat.domain.user.dto.req.UserCreateReqDto;
import privatechat.privatechat.domain.user.dto.res.UserResDto;
import privatechat.privatechat.domain.user.service.UserCreateService;
import privatechat.privatechat.global.common.response.ApiResponse;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserCreateService userCreateService;

    @PostMapping("/signup")
    public ApiResponse<UserResDto> signUp(@Valid UserCreateReqDto reqDto) {
        return ApiResponse.of(HttpStatus.OK, "회원가입 성공", userCreateService.execute(reqDto));
    }
}
