package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.donl.health.model.bean.user.LoginBean;
import top.donl.health.model.bean.user.RegisterBean;
import top.donl.health.model.vo.user.UserVO;
import top.donl.health.service.UserService;
import top.donl.util.response.BaseResponse;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public BaseResponse<String> login(@RequestBody LoginBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public BaseResponse<String> register(@RequestBody RegisterBean bean) {
        String token = userService.register(bean);
        return BaseResponse.success(token);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping
    public BaseResponse<UserVO> userInfo() {
        return BaseResponse.success(userService.detail());
    }
}
