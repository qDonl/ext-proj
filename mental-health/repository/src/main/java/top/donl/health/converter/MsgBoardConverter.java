package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.msg.MsgBoardBean;
import top.donl.health.model.po.MsgBoard;
import top.donl.health.model.vo.msg.MsgBoardVO;


@Mapper(componentModel = "spring")
public interface MsgBoardConverter {

    MsgBoard bean2Po(MsgBoardBean bean);

    MsgBoardVO po2Vo(MsgBoard po);
}
