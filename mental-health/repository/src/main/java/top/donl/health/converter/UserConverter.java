package top.donl.health.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.user.UserVO;

/**
 * @author Crux
 * @since 2023-03-05 18:19:20
 */

@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mapping(target = "password", expression = "java(top.donl.util.md5.Md5Util.md5(bean.getPassword()))")
    User bean2Po(RegisterBean bean);

    UserVO po2Vo(User user);
}
