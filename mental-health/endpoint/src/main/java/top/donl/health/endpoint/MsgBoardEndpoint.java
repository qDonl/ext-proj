package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.msg.MsgBoardBean;
import top.donl.health.model.vo.msg.MsgBoardVO;
import top.donl.health.service.MsgBoardService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;
import top.donl.util.response.BaseResponse;


@Api(tags = "留言板")
@RestController
@RequestMapping(value = "/msg-board")
@RequiredArgsConstructor
public class MsgBoardEndpoint {

    private final MsgBoardService msgBoardService;

    @ApiOperation(value = "新增公告")
    @PostMapping("/add")
    public BaseResponse<MsgBoardVO> add(@Validated(value = {InsertGroup.class}) @RequestBody MsgBoardBean bean) {
        return BaseResponse.success(msgBoardService.addMsg(bean));
    }

    @ApiOperation(value = "更新公告")
    @PutMapping("/update")
    public BaseResponse<MsgBoardVO> update(@Validated(value = {UpdateGroup.class}) @RequestBody MsgBoardBean bean) {
        return BaseResponse.success(msgBoardService.updateMsg(bean));
    }

    @ApiOperation(value = "公告列表")
    @GetMapping("/list")
    public BaseResponse<PageResult<MsgBoardVO>> list(BaseQuery query) {
        return BaseResponse.success(msgBoardService.listMsgBoard(query));
    }

}
