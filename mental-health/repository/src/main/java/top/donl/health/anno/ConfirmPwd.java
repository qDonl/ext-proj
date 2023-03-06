package top.donl.health.anno;


import top.donl.health.validator.ConfirmPwdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmPwdValidator.class)
@Documented
public @interface ConfirmPwd {

    String message() default "确认密码和密码不一致";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
