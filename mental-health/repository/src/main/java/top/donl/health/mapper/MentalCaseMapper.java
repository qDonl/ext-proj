package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.MentalCase;
import top.donl.health.model.query.cases.MentalCaseQuery;
import top.donl.health.model.vo.cases.MentalCaseVO;

import java.util.List;


@Repository
public interface MentalCaseMapper extends BaseMapper<MentalCase> {
    int updateBatch(List<MentalCase> list);

    int updateBatchSelective(List<MentalCase> list);

    int batchInsert(@Param("list") List<MentalCase> list);

    int insertOrUpdate(MentalCase record);

    int insertOrUpdateSelective(MentalCase record);

    long findCountByQuery(@Param("query") MentalCaseQuery query);
    List<MentalCaseVO> findByQuery(@Param("query") MentalCaseQuery query);
}