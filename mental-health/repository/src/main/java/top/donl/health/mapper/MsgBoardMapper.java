package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MsgBoard;
import top.donl.health.model.vo.msg.MsgBoardVO;
import top.donl.util.common.domain.query.BaseQuery;

import java.util.List;


@Repository
public interface MsgBoardMapper extends BaseMapper<MsgBoard> {

    long findTotalCount();

    List<MsgBoardVO> findListByQuery(@Param("query") BaseQuery query);
}