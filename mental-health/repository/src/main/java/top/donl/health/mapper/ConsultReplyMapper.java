package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.ConsultReply;

import java.util.List;



@Repository
public interface ConsultReplyMapper extends BaseMapper<ConsultReply> {
    int updateBatch(List<ConsultReply> list);

    int updateBatchSelective(List<ConsultReply> list);

    int batchInsert(@Param("list") List<ConsultReply> list);

    int insertOrUpdate(ConsultReply record);

    int insertOrUpdateSelective(ConsultReply record);
}