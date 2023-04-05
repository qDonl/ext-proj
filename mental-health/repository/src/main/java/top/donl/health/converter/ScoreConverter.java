package top.donl.health.converter;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import top.donl.health.model.bean.score.EvaluationScoreBean;
import top.donl.health.model.po.EvaluationScore;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScoreConverter {

    EvaluationScore bean2Po(EvaluationScoreBean bean);
}
