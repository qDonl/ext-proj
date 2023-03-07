package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.evaluation.MentalEvaluationBean;
import top.donl.health.model.po.MentalEvaluation;
import top.donl.health.model.query.evaluation.MentalEvaluationQuery;
import top.donl.health.model.vo.evaluation.MentalEvaluationVO;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;

public interface MentalEvaluationService extends IService<MentalEvaluation>{

    MentalEvaluationVO add(MentalEvaluationBean bean);
    MentalEvaluationVO update(MentalEvaluationBean bean);
    PageResult<MentalEvaluationVO> list(MentalEvaluationQuery query);
}
