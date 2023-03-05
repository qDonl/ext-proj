package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.donl.health.model.po.Account;
import top.donl.health.service.AccountService;
import top.donl.util.exceptioins.RestResponseExceptionEnum;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 10:10:07
 */

@Api(tags = "Account管理")
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountEndpoint {

    private final AccountService accountService;

    @ApiOperation("查找-find")
    @GetMapping("/find/")
    public Account findById(Integer id) {
        return accountService.findById(id);
    }

    @ApiOperation("查找-select")
    @GetMapping("/select/")
    public Account useSelect(Integer id) {
        return accountService.useSelect(id);
    }

    @ApiOperation("抛出异常")
    @GetMapping("/thrs/")
    public void thrExp(Boolean thrs) {
        RestResponseExceptionEnum.CUSTOM_ERROR.assertIsFalse(thrs);
    }
}
