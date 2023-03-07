package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.ConsultReplyConverter;
import top.donl.health.mapper.ConsultMapper;
import top.donl.health.mapper.ConsultReplyMapper;
import top.donl.health.model.bean.consultReply.ConsultReplyBean;
import top.donl.health.model.po.Consult;
import top.donl.health.model.po.ConsultReply;
import top.donl.health.model.query.consultReply.ConsultReplyQuery;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;
import top.donl.health.service.ConsultReplyService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.exceptioins.RestResponseExceptionEnum;
import top.donl.util.holder.UserCtxHolder;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ConsultReplyServiceImpl
        extends ServiceImpl<ConsultReplyMapper, ConsultReply>
        implements ConsultReplyService{

    private final ConsultReplyConverter consultReplyConverter;

    private final ConsultMapper consultMapper;

    @Override
    public ConsultReplyVO add(ConsultReplyBean bean) {
        Consult consult = consultMapper.selectById(bean.getConsultId());
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(consult != null, "未找到该咨询信息");

        ConsultReply consultReply = consultReplyConverter.bean2Po(bean);
        consultReply.setReplier(UserCtxHolder.getUserInfo().getUsername());
        baseMapper.insert(consultReply);
        return consultReplyConverter.po2Vo(consultReply);
    }

    @Override
    public ConsultReplyVO update(ConsultReplyBean bean) {
        Long userId = UserCtxHolder.getUserInfo().getUserId();
        Consult consult = consultMapper.selectById(bean.getConsultId());
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(consult != null, "未找到该咨询信息");

        ConsultReply consultReply = baseMapper.selectById(bean.getId());
        RestResponseExceptionEnum.NOT_FOUND_ELEMENT.assertIsTrue(consultReply != null, "未找到该回复信息");
        RestResponseExceptionEnum.CUSTOM_ERROR.assertIsTrue(userId.equals(consultReply.getCreateBy()), "只可修改自己的内容");

        ConsultReply reply = consultReplyConverter.bean2Po(bean);
        baseMapper.updateById(reply);
        return consultReplyConverter.po2Vo(reply);
    }

    @Override
    public PageResult<ConsultReplyVO> list(ConsultReplyQuery query) {
        long totalCount = baseMapper.findCountByQuery(query);
        if (totalCount == 0L) {
            return PageResult.toPageResult(null, query, totalCount);
        }

        List<ConsultReplyVO> list = baseMapper.findByQuery(query);
        return PageResult.toPageResult(list, query, totalCount);
    }

}
