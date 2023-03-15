package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.MsgBoardConverter;
import top.donl.health.mapper.MsgBoardMapper;
import top.donl.health.model.bean.msg.MsgBoardBean;
import top.donl.health.model.po.MsgBoard;
import top.donl.health.model.vo.msg.MsgBoardVO;
import top.donl.health.service.MsgBoardService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MsgBoardServiceImpl
        extends ServiceImpl<MsgBoardMapper, MsgBoard>
        implements MsgBoardService{

    private final MsgBoardConverter msgBoardConverter;

    @Override
    public MsgBoardVO addMsg(MsgBoardBean bean) {
        MsgBoard po = msgBoardConverter.bean2Po(bean);
        baseMapper.insert(po);
        return msgBoardConverter.po2Vo(po);
    }

    @Override
    public MsgBoardVO updateMsg(MsgBoardBean bean) {
        MsgBoard po = msgBoardConverter.bean2Po(bean);
        baseMapper.updateById(po);
        return msgBoardConverter.po2Vo(po);
    }

    @Override
    public PageResult<MsgBoardVO> listMsgBoard(BaseQuery query) {
        long total = baseMapper.findTotalCount();
        if (total == 0) {
            return PageResult.toPageResult(null, query, total);
        }

        List<MsgBoardVO> list = baseMapper.findListByQuery(query);
        return PageResult.toPageResult(list, query, total);
    }

}
