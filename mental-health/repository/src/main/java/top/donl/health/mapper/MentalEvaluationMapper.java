package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MentalEvaluation;

import java.util.List;



@Repository
public interface MentalEvaluationMapper extends BaseMapper<MentalEvaluation> {
    int updateBatch(List<MentalEvaluation> list);

    int updateBatchSelective(List<MentalEvaluation> list);

    int batchInsert(@Param("list") List<MentalEvaluation> list);

    int insertOrUpdate(MentalEvaluation record);

    int insertOrUpdateSelective(MentalEvaluation record);
}