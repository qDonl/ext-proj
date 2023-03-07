package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.MentalEvaluationConverter;
import top.donl.health.mapper.MentalEvaluationMapper;
import top.donl.health.model.bean.evaluation.MentalEvaluationBean;
import top.donl.health.model.po.MentalEvaluation;
import top.donl.health.model.query.evaluation.MentalEvaluationQuery;
import top.donl.health.model.vo.evaluation.MentalEvaluationVO;
import top.donl.health.service.MentalEvaluationService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentalEvaluationServiceImpl
        extends ServiceImpl<MentalEvaluationMapper, MentalEvaluation>
        implements MentalEvaluationService {

    private final MentalEvaluationConverter mentalEvaluationConverter;

    @Override
    public MentalEvaluationVO add(MentalEvaluationBean bean) {
        MentalEvaluation mentalEvaluation = mentalEvaluationConverter.bean2Po(bean);
        mentalEvaluation.setPublisher(UserCtxHolder.getUserInfo().getUsername());
        baseMapper.insert(mentalEvaluation);
        return mentalEvaluationConverter.po2Vo(mentalEvaluation);
    }

    @Override
    public MentalEvaluationVO update(MentalEvaluationBean bean) {
        Long userId = UserCtxHolder.getUserInfo().getUserId();
        MentalEvaluation po = baseMapper.selectById(bean.getId());
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(po != null, "未找到当前数据");
        RestResponseExceptionEnum.CUSTOM_ERROR.assertIsTrue(userId.equals(po.getCreateBy()), "不可修改别人提交的数据");

        MentalEvaluation mentalEvaluation = mentalEvaluationConverter.bean2Po(bean);
        baseMapper.updateById(mentalEvaluation);
        return mentalEvaluationConverter.po2Vo(mentalEvaluation);
    }

    @Override
    public PageResult<MentalEvaluationVO> list(MentalEvaluationQuery query) {
        long totalCount = baseMapper.findCountByQuery(query);
        if (totalCount == 0) {
            return PageResult.toPageResult(null, query, totalCount);
        }

        List<MentalEvaluationVO> list = baseMapper.findByQuery(query);
        return PageResult.toPageResult(list, query,totalCount);
    }
}
