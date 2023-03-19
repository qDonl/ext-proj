package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MentalEvaluation;
import top.donl.health.model.query.evaluation.MentalEvaluationQuery;
import top.donl.health.model.vo.evaluation.MentalEvaluationVO;

import java.util.List;


@Repository
public interface MentalEvaluationMapper extends BaseMapper<MentalEvaluation> {

    long findCountByQuery(@Param("query") MentalEvaluationQuery query);

    List<MentalEvaluationVO> findByQuery(@Param("query") MentalEvaluationQuery query);
}