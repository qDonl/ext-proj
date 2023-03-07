package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.consultReply.ConsultReplyBean;
import top.donl.health.model.po.ConsultReply;
import top.donl.health.model.query.consultReply.ConsultReplyQuery;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;
import top.donl.util.common.domain.page.PageResult;

public interface ConsultReplyService extends IService<ConsultReply>{

    ConsultReplyVO add(ConsultReplyBean bean);

    ConsultReplyVO update(ConsultReplyBean bean);

    PageResult<ConsultReplyVO> list(ConsultReplyQuery query);
}
