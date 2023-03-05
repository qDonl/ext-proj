package top.donl.health.configurer.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.donl.bean.util.holder.RequestCtxHolder;
import top.donl.health.common.ConstantPair;
import top.donl.health.common.util.JwtUtils;
import top.donl.util.common.domain.info.UserInfo;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户认证拦截器
 */


@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenStr = RequestCtxHolder.getHeader(ConstantPair.AUTH_HEADER);
        RestResponseExceptionEnum.NEED_LOGIN.assertIsTrue(StringUtils.isNotBlank(tokenStr));

        UserInfo user = JwtUtils.parseToken(tokenStr);
        RestResponseExceptionEnum.NEED_LOGIN.assertIsTrue(user != null);
        UserCtxHolder.setUserInfo(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserCtxHolder.removeUserInfo();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserCtxHolder.removeUserInfo();
    }
}
