package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.po.User;

/**
 * @author Crux
 * @since 2023-03-05 18:19:20
 */

@Mapper(componentModel = "spring")
public interface UserConverter {

    User bean2Po(RegisterBean bean);
}
