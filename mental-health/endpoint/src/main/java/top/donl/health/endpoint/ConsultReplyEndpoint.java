package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.consultReply.ConsultReplyBean;
import top.donl.health.model.query.consultReply.ConsultReplyQuery;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;
import top.donl.health.service.ConsultReplyService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.response.BaseResponse;


@Api(tags = "咨询回复模块")
@RestController
@RequestMapping(value = "/consult-reply")
@RequiredArgsConstructor
public class ConsultReplyEndpoint {

    private final ConsultReplyService consultReplyService;

    @ApiOperation(value = "新增咨询回复")
    @PostMapping(value = "/add")
    public BaseResponse<ConsultReplyVO> add(@Validated(value = InsertGroup.class) @RequestBody ConsultReplyBean bean) {
        return BaseResponse.success(consultReplyService.add(bean));
    }

    @ApiOperation(value = "更新咨询回复")
    @PutMapping(value = "/update")
    public BaseResponse<ConsultReplyVO> update(@Validated(value = UpdateGroup.class) @RequestBody ConsultReplyBean bean) {
        return BaseResponse.success(consultReplyService.update(bean));
    }

    @ApiOperation(value = "当前咨询下的所有回复")
    @GetMapping(value = "/list")
    public BaseResponse<PageResult<ConsultReplyVO>> list(ConsultReplyQuery query) {
        return BaseResponse.success(consultReplyService.list(query));
    }

}
