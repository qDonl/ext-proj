package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.SysAnno;
import top.donl.health.model.vo.anno.AnnoVO;
import top.donl.util.common.domain.query.BaseQuery;

import java.util.List;



@Repository
public interface SysAnnoMapper extends BaseMapper<SysAnno> {
    int updateBatch(List<SysAnno> list);

    int updateBatchSelective(List<SysAnno> list);

    int batchInsert(@Param("list") List<SysAnno> list);

    int insertOrUpdate(SysAnno record);

    int insertOrUpdateSelective(SysAnno record);

    long findTotalCount();

    List<AnnoVO> findAnnoList(@Param("query") BaseQuery query);
}