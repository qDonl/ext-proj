package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.EvaluationScore;
import top.donl.health.model.vo.score.ScoreVO;

import java.util.List;


@Repository
public interface EvaluationScoreMapper extends BaseMapper<EvaluationScore> {

    List<ScoreVO> findSelf(@Param("userId") Long userId);

    List<ScoreVO> findByRealName(@Param("realName") String realName);
}