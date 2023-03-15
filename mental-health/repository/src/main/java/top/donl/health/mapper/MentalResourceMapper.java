package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MentalResource;
import top.donl.health.model.query.resource.MentalResourceQuery;
import top.donl.health.model.vo.resource.MentalResourceVO;

import java.util.List;



@Repository
public interface MentalResourceMapper extends BaseMapper<MentalResource> {

    long findTotalCountByQuery(@Param("query") MentalResourceQuery query);

    List<MentalResourceVO> findByList(@Param("query") MentalResourceQuery query);
}