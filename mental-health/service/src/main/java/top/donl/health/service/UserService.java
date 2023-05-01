package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.user.LoginBean;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.user.UserVO;

import java.util.List;

public interface UserService extends IService<User>{

    String register(RegisterBean bean);

    String login(LoginBean bean);

    UserVO detail();

    List<UserVO> userList();

    void deleteUser(Long userId);

}
