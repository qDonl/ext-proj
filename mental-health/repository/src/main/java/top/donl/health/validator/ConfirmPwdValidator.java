package top.donl.health.validator;

import org.apache.commons.lang3.StringUtils;
import top.donl.health.anno.ConfirmPwd;
import top.donl.health.model.bean.user.RegisterBean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ConfirmPwdValidator implements ConstraintValidator<ConfirmPwd, RegisterBean> {

    @Override
    public boolean isValid(RegisterBean value, ConstraintValidatorContext context) {
        String password = value.getPassword();
        String confirmPassword = value.getConfirmPassword();
        if (StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
            return false;
        }

        return StringUtils.equals(password, confirmPassword);
    }

    @Override
    public void initialize(ConfirmPwd constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
