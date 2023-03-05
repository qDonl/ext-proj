package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.UserConverter;
import top.donl.health.mapper.UserMapper;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.UserVO;
import top.donl.health.service.UserService;
import top.donl.util.common.domain.info.UserInfo;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService{

    private final UserConverter userConverter;

    @Override
    public String register(RegisterBean bean) {
        User po = userConverter.bean2Po(bean);
        baseMapper.insert(po);
        return String.valueOf(po.getId());
    }

    @Override
    public UserVO detail() {
        UserInfo userInfo = UserCtxHolder.getUserInfo();
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(userInfo != null, "该用户不存在");
        return baseMapper.findById(userInfo.getUserId());
    }
}
