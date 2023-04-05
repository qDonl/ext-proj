package top.donl.health.service;

import top.donl.health.model.bean.score.EvaluationScoreBean;
import top.donl.health.model.po.EvaluationScore;
import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.vo.score.ScoreVO;

import java.util.List;


public interface EvaluationScoreService extends IService<EvaluationScore>{

    void add(EvaluationScoreBean bean);

    List<ScoreVO> findSelf();
}
