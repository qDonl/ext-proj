package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.msg.MsgBoardBean;
import top.donl.health.model.po.MsgBoard;
import top.donl.health.model.vo.msg.MsgBoardVO;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;

public interface MsgBoardService extends IService<MsgBoard>{

    MsgBoardVO addMsg(MsgBoardBean bean);

    MsgBoardVO updateMsg(MsgBoardBean bean);

    PageResult<MsgBoardVO> listMsgBoard(BaseQuery query);




}
