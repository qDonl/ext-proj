package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.donl.bean.util.holder.RequestCtxHolder;
import top.donl.bean.util.holder.RequestCtxHolderWrapper;
import top.donl.health.common.ConstantPair;
import top.donl.health.common.util.JwtUtils;
import top.donl.health.converter.UserConverter;
import top.donl.health.mapper.UserMapper;
import top.donl.health.model.bean.user.LoginBean;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.user.UserVO;
import top.donl.health.service.UserService;
import top.donl.util.common.domain.info.UserInfo;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;
import top.donl.util.md5.Md5Util;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService{

    private final UserConverter userConverter;

    @Override
    public String register(RegisterBean bean) {
        User phoneUser = baseMapper.findByPhone(bean.getPhone());
        RestResponseExceptionEnum.PHONE_EXISTED.assertIsTrue(phoneUser == null);

        User po = userConverter.bean2Po(bean);
        baseMapper.insert(po);
        UserVO userVO = userConverter.po2Vo(po);
        String token = JwtUtils.generateToken(userVO);
        RequestCtxHolderWrapper reqWrapper = new RequestCtxHolderWrapper(RequestCtxHolder.getRequest());
        reqWrapper.putHeader(ConstantPair.AUTH_HEADER, token);
        return token;
    }

    @Override
    public String login(LoginBean bean) {
        User phoneUser = baseMapper.findByPhone(bean.getPhone());
        RestResponseExceptionEnum.LOGIN_FAILED.assertIsTrue(phoneUser != null);

        String md5Pwd = Md5Util.md5(bean.getPassword());
        RestResponseExceptionEnum.LOGIN_FAILED.assertIsTrue(StringUtils.equals(md5Pwd, phoneUser.getPhone()));
        UserVO userVO = userConverter.po2Vo(phoneUser);
        String token = JwtUtils.generateToken(userVO);
        RequestCtxHolderWrapper reqWrapper = new RequestCtxHolderWrapper(RequestCtxHolder.getRequest());
        reqWrapper.putHeader(ConstantPair.AUTH_HEADER, token);
        return token;
    }

    @Override
    public UserVO detail() {
        UserInfo userInfo = UserCtxHolder.getUserInfo();
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(userInfo != null, "该用户不存在");
        return baseMapper.findById(userInfo.getUserId());
    }
}
