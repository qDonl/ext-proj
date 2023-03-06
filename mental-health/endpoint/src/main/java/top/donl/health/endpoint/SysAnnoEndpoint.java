package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.anno.AnnoBean;
import top.donl.health.model.vo.anno.AnnoVO;
import top.donl.health.service.SysAnnoService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;
import top.donl.util.response.BaseResponse;


@Api(tags = "系统公告")
@RestController
@RequestMapping(value = "/sys-anno")
@RequiredArgsConstructor
public class SysAnnoEndpoint {

    private final SysAnnoService sysAnnoService;

    @ApiOperation(value = "新增公告")
    @PostMapping("/add")
    public BaseResponse<AnnoVO> add(@Validated(value = InsertGroup.class) @RequestBody AnnoBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "新增公告")
    @PutMapping("/add")
    public BaseResponse<AnnoVO> update(@Validated(value = UpdateGroup.class) @RequestBody AnnoBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "公告列表")
    @GetMapping("/list")
    public BaseResponse<PageResult<AnnoVO>> list(@RequestParam BaseQuery query) {
        return BaseResponse.success();
    }
}
