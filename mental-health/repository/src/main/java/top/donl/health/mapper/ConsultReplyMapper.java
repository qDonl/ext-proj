package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.ConsultReply;
import top.donl.health.model.query.consultReply.ConsultReplyQuery;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;

import java.util.List;



@Repository
public interface ConsultReplyMapper extends BaseMapper<ConsultReply> {

    long findCountByQuery(@Param("query") ConsultReplyQuery query);

    List<ConsultReplyVO> findByQuery(@Param("query") ConsultReplyQuery query);

    List<ConsultReplyVO> findByConsultId(@Param("consultId") Long consultId);
}