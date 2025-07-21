package privatechat.privatechat.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import privatechat.privatechat.domain.user.dto.req.UserCreateReqDto;
import privatechat.privatechat.domain.user.dto.res.UserResDto;
import privatechat.privatechat.domain.user.entity.User;
import privatechat.privatechat.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserCreateService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResDto execute(UserCreateReqDto reqDto) {
        if (isDuplicateEmail(reqDto.email())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        if (isDuplicateName(reqDto.name())) {
            throw new IllegalArgumentException("이미 사용 중인 이름입니다.");
        }
        String hashedPassword = hashPassword(reqDto.password());
        User user = User.builder()
                .name(reqDto.name())
                .password(hashedPassword)
                .email(reqDto.email())
                .build();
        userRepository.save(user);
        return new UserResDto(user.getId(), user.getName(), user.getEmail());
    }

    private boolean isDuplicateEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    private boolean isDuplicateName(String name) {
        return userRepository.existsByName(name);
    }
    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
