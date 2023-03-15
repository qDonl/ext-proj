package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.consultReply.ConsultReplyBean;
import top.donl.health.model.po.ConsultReply;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;

@Mapper(componentModel = "spring")
public interface ConsultReplyConverter {

    ConsultReply bean2Po(ConsultReplyBean bean);

    ConsultReplyVO po2Vo(ConsultReply po);
}
