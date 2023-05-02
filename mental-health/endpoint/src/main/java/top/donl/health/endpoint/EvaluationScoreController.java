package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.donl.health.model.bean.score.EvaluationScoreBean;
import top.donl.health.model.vo.score.ScoreVO;
import top.donl.health.service.EvaluationScoreService;
import top.donl.util.response.BaseResponse;

import java.util.List;


@Api(tags = "评测模块评分")
@RestController
@RequestMapping(value = "/evaluation-score")
@RequiredArgsConstructor
public class EvaluationScoreController {

    private final EvaluationScoreService evaluationScoreService;

    @PostMapping("/add")
    public BaseResponse<Void> add(@Validated @RequestBody EvaluationScoreBean bean) {
        evaluationScoreService.add(bean);
        return BaseResponse.success();
    }

    @GetMapping("self")
    public BaseResponse<List<ScoreVO>> findSelf() {
        return BaseResponse.success(evaluationScoreService.findSelf());
    }

    @GetMapping("/find")
    public BaseResponse<List<ScoreVO>> findByUserName(String realName) {
        return BaseResponse.success(evaluationScoreService.findByRealName(realName));
    }
}
