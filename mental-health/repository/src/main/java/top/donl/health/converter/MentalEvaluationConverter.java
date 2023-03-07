package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.evaluation.MentalEvaluationBean;
import top.donl.health.model.po.MentalEvaluation;
import top.donl.health.model.vo.evaluation.MentalEvaluationVO;


@Mapper(componentModel = "spring")
public interface MentalEvaluationConverter {

    MentalEvaluation bean2Po(MentalEvaluationBean bean);

    MentalEvaluationVO po2Vo(MentalEvaluation po);
}
