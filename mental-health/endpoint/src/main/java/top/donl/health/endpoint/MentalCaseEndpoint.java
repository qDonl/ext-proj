package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.cases.MentalCaseBean;
import top.donl.health.model.query.cases.MentalCaseQuery;
import top.donl.health.model.vo.cases.MentalCaseVO;
import top.donl.health.service.MentalCaseService;
import top.donl.mybatisplus.util.PageResult;
import top.donl.util.response.BaseResponse;


@Api(tags = "案例模块")
@RestController
@RequestMapping(value = "/case")
@RequiredArgsConstructor
public class MentalCaseEndpoint {

    private final MentalCaseService mentalCaseService;

    @ApiOperation(value = "新增案例")
    @PostMapping(value = "/add")
    public BaseResponse<MentalCaseVO> add(@Validated(value = InsertGroup.class) @RequestBody MentalCaseBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "更新案例")
    @PutMapping(value = "/update")
    public BaseResponse<MentalCaseVO> update(@Validated(value = UpdateGroup.class) @RequestBody MentalCaseBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "案例列表")
    @GetMapping(value = "/list")
    public BaseResponse<PageResult<MentalCaseVO>> list(MentalCaseQuery query) {
        return BaseResponse.success();
    }

}
