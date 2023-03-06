package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.user.UserVO;

public interface UserService extends IService<User>{

    String register(RegisterBean bean);

    UserVO detail();

}
