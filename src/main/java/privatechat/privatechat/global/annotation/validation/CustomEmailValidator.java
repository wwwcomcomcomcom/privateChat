package privatechat.privatechat.global.annotation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Email(message = "유효하지 않은 이메일 형식입니다.",regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
@NotNull(message = "이메일은 필수 입력입니다.")
@Constraint(validatedBy = {})
public @interface CustomEmailValidator {
}
