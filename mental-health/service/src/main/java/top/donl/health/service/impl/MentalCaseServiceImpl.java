package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.MentalCaseConverter;
import top.donl.health.mapper.MentalCaseMapper;
import top.donl.health.model.bean.cases.MentalCaseBean;
import top.donl.health.model.po.MentalCase;
import top.donl.health.model.query.cases.MentalCaseQuery;
import top.donl.health.model.vo.cases.MentalCaseVO;
import top.donl.health.service.MentalCaseService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentalCaseServiceImpl
        extends ServiceImpl<MentalCaseMapper, MentalCase>
        implements MentalCaseService{

    private final MentalCaseConverter mentalCaseConverter;

    @Override
    public MentalCaseVO add(MentalCaseBean bean) {
        MentalCase mentalCase = mentalCaseConverter.bean2Po(bean);
        mentalCase.setPublisher(UserCtxHolder.getUserInfo().getUsername());
        baseMapper.insert(mentalCase);
        return mentalCaseConverter.po2Vo(mentalCase);
    }

    @Override
    public MentalCaseVO update(MentalCaseBean bean) {
        Long userId = UserCtxHolder.getUserInfo().getUserId();
        MentalCase mentalCase = baseMapper.selectById(bean.getId());
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(mentalCase != null, "未找到当前案例");
        RestResponseExceptionEnum.CUSTOM_ERROR.assertIsTrue(userId.equals(mentalCase.getCreateBy()), "只可修改自己提交的案例信息");

        MentalCase mentalCasePo = mentalCaseConverter.bean2Po(bean);
        baseMapper.updateById(mentalCasePo);
        return mentalCaseConverter.po2Vo(mentalCasePo);
    }

    @Override
    public PageResult<MentalCaseVO> list(MentalCaseQuery query) {
        long totalCount = baseMapper.findCountByQuery(query);
        if (totalCount == 0) {
            return PageResult.toPageResult(null, query, totalCount);
        }

        List<MentalCaseVO> list = baseMapper.findByQuery(query);
        return PageResult.toPageResult(list, query, totalCount);
    }
}
