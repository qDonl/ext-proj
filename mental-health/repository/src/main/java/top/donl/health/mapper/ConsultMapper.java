package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.Consult;
import top.donl.health.model.query.consult.ConsultQuery;
import top.donl.health.model.vo.consult.ConsultVO;

import java.util.List;

 
@Repository
public interface ConsultMapper extends BaseMapper<Consult> {
    int updateBatch(List<Consult> list);

    int updateBatchSelective(List<Consult> list);

    int batchInsert(@Param("list") List<Consult> list);

    int insertOrUpdate(Consult record);

    int insertOrUpdateSelective(Consult record);

    List<ConsultVO> findByQuery(@Param("query") ConsultQuery query);

    Long findCountByQuery(@Param("query") ConsultQuery query);
}