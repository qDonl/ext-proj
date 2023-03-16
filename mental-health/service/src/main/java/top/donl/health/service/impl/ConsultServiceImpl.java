package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.ConsultConverter;
import top.donl.health.mapper.ConsultMapper;
import top.donl.health.model.bean.consult.ConsultBean;
import top.donl.health.model.po.Consult;
import top.donl.health.model.query.consult.ConsultQuery;
import top.donl.health.model.vo.consult.ConsultVO;
import top.donl.health.service.ConsultService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl
        extends ServiceImpl<ConsultMapper, Consult>
        implements ConsultService{

    private final ConsultConverter consultConverter;

    @Override
    public ConsultVO add(ConsultBean bean) {
        Consult consult = consultConverter.bean2Po(bean);
        consult.setConsultant(UserCtxHolder.getUserInfo().getUsername());
        baseMapper.insert(consult);
        return consultConverter.po2Vo(consult);
    }

    @Override
    public ConsultVO update(ConsultBean bean) {
        Long userId = UserCtxHolder.getUserInfo().getUserId();
        Consult consult = baseMapper.selectById(bean.getId());
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(consult != null, "未找到当前咨询信息");
        RestResponseExceptionEnum.CUSTOM_ERROR.assertIsTrue(consult.getCreateBy().equals(userId), "不可修改别人创建的文章");

        Consult result = consultConverter.bean2Po(bean);
        baseMapper.updateById(result);
        return consultConverter.po2Vo(result);
    }

    @Override
    public PageResult<ConsultVO> list(ConsultQuery query, Boolean isSelf) {
        if (Boolean.TRUE.equals(isSelf)) {
            query.setUserId(UserCtxHolder.getUserInfo().getUserId());
        }

        Long count = baseMapper.findCountByQuery(query);
        if (count == null || count == 0L) {
            return PageResult.toPageResult(null, query, count);
        }

        List<ConsultVO> list = baseMapper.findByQuery(query);
        return PageResult.toPageResult(list, query, count);
    }
}
