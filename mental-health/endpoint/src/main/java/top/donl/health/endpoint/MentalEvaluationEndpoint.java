package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.evaluation.MentalEvaluationBean;
import top.donl.health.model.query.evaluation.MentalEvaluationQuery;
import top.donl.health.model.vo.evaluation.MentalEvaluationVO;
import top.donl.health.service.MentalEvaluationService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.response.BaseResponse;


@Api(tags = "咨询评估")
@RestController
@RequestMapping(value = "/evaluation")
@RequiredArgsConstructor
public class MentalEvaluationEndpoint {

    private final MentalEvaluationService mentalEvaluationService;

    @ApiOperation(value = "新增咨询评估")
    @PostMapping("/add")
    public BaseResponse<MentalEvaluationVO> add(@Validated(value = {InsertGroup.class}) @RequestBody MentalEvaluationBean bean) {
        return BaseResponse.success(mentalEvaluationService.add(bean));
    }

    @ApiOperation(value = "更新咨询评估")
    @PutMapping("/update")
    public BaseResponse<MentalEvaluationVO> update(@Validated(value = {UpdateGroup.class}) @RequestBody MentalEvaluationBean bean) {
        return BaseResponse.success(mentalEvaluationService.update(bean));
    }

    @ApiOperation(value = "咨询评估列表")
    @GetMapping("/list")
    public BaseResponse<PageResult<MentalEvaluationVO>> list(MentalEvaluationQuery query) {
        return BaseResponse.success(mentalEvaluationService.list(query));
    }
}
