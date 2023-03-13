package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.donl.health.common.RoleEnum;
import top.donl.health.common.model.dto.BaseDictDTO;
import top.donl.health.model.vo.dict.BaseDictVO;
import top.donl.util.response.BaseResponse;

import java.util.List;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/03/13 09:26:30
 */

@Api(tags = "通用模块")
@RestController
@RequestMapping(value = "/pass")
@RequiredArgsConstructor
public class PassController {

    @GetMapping("/dict")
    public BaseResponse<BaseDictVO> dict() {
        List<BaseDictDTO> roleDict = RoleEnum.dictDto();
        BaseDictVO baseDict = new BaseDictVO(roleDict);
        return BaseResponse.success(baseDict);
    }
}
