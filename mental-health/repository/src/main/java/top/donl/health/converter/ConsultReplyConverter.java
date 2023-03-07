package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.consultReply.ConsultReplyBean;
import top.donl.health.model.po.ConsultReply;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/03/07 09:21:21
 */

@Mapper(componentModel = "spring")
public interface ConsultReplyConverter {

    ConsultReply bean2Po(ConsultReplyBean bean);

    ConsultReplyVO po2Vo(ConsultReply po);
}
