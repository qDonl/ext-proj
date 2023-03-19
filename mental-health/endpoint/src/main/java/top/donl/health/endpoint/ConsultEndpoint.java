package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.consult.ConsultBean;
import top.donl.health.model.query.consult.ConsultQuery;
import top.donl.health.model.vo.consult.ConsultInfoVo;
import top.donl.health.model.vo.consult.ConsultVO;
import top.donl.health.service.ConsultService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.response.BaseResponse;


@Api(tags = "咨询模块")
@RestController
@RequestMapping(value = "/consult")
@RequiredArgsConstructor
public class ConsultEndpoint {

    private final ConsultService consultService;

    @ApiOperation(value = "新增咨询回复")
    @PostMapping(value = "/add")
    public BaseResponse<ConsultVO> add(@Validated(value = InsertGroup.class) @RequestBody ConsultBean bean) {
        return BaseResponse.success(consultService.add(bean));
    }

    @ApiOperation(value = "更新咨询回复")
    @PutMapping(value = "/update")
    public BaseResponse<ConsultVO> update(@Validated(value = UpdateGroup.class) @RequestBody ConsultBean bean) {
        return BaseResponse.success(consultService.update(bean));
    }

    @ApiOperation(value = "咨询列表", response = ConsultVO.class)
    @GetMapping(value = "/list")
    public BaseResponse<PageResult<ConsultVO>> list(ConsultQuery query) {
        return BaseResponse.success(consultService.list(query, Boolean.FALSE));
    }

    @ApiOperation(value = "获取咨询详情")
    @GetMapping("/detail/{consultId}")
    public BaseResponse<ConsultInfoVo> getDetail(@PathVariable("consultId") Long consultId) {
        return BaseResponse.success(consultService.detail(consultId));
    }

    @ApiOperation(value = "我的咨询列表", response = ConsultVO.class)
    @GetMapping(value = "/list-self")
    public BaseResponse<PageResult<ConsultVO>> selfList(ConsultQuery query) {
        return BaseResponse.success(consultService.list(query, Boolean.TRUE));
    }

}
