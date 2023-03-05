package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MentalResource;

import java.util.List;



@Repository
public interface MentalResourceMapper extends BaseMapper<MentalResource> {
    int updateBatch(List<MentalResource> list);

    int updateBatchSelective(List<MentalResource> list);

    int batchInsert(@Param("list") List<MentalResource> list);

    int insertOrUpdate(MentalResource record);

    int insertOrUpdateSelective(MentalResource record);
}