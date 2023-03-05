package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.MentalEvaluationMapper;
import top.donl.health.model.po.MentalEvaluation;
import top.donl.health.service.MentalEvaluationService;

@Service
@RequiredArgsConstructor
public class MentalEvaluationServiceImpl
        extends ServiceImpl<MentalEvaluationMapper, MentalEvaluation>
        implements MentalEvaluationService{
}
