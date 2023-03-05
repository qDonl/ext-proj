package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MsgBoard;

import java.util.List;



@Repository
public interface MsgBoardMapper extends BaseMapper<MsgBoard> {
    int updateBatch(List<MsgBoard> list);

    int updateBatchSelective(List<MsgBoard> list);

    int batchInsert(@Param("list") List<MsgBoard> list);

    int insertOrUpdate(MsgBoard record);

    int insertOrUpdateSelective(MsgBoard record);
}