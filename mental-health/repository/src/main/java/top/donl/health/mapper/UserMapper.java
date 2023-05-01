package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.user.UserVO;

import java.util.List;


@Repository
public interface UserMapper extends BaseMapper<User> {

    User findById(@Param("userId") Long userId);

    User findByPhone(@Param("phone") String phone);

    List<User> userList();

    int update2Delete(@Param("userId") Long userId);
}