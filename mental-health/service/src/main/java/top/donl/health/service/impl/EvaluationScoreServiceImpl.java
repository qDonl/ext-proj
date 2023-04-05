package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.ScoreConverter;
import top.donl.health.mapper.EvaluationScoreMapper;
import top.donl.health.model.bean.score.EvaluationScoreBean;
import top.donl.health.model.po.EvaluationScore;
import top.donl.health.model.vo.score.ScoreVO;
import top.donl.health.service.EvaluationScoreService;
import top.donl.util.holder.UserCtxHolder;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EvaluationScoreServiceImpl
        extends ServiceImpl<EvaluationScoreMapper, EvaluationScore>
        implements EvaluationScoreService {

    private final ScoreConverter scoreConverter;

    @Override
    public void add(EvaluationScoreBean bean) {
        EvaluationScore po = scoreConverter.bean2Po(bean);
        baseMapper.insert(po);
    }

    @Override
    public List<ScoreVO> findSelf() {
        Long userId = UserCtxHolder.getUserInfo().getUserId();
        return baseMapper.findSelf(userId);
    }
}
