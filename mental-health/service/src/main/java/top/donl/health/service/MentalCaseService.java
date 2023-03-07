package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.cases.MentalCaseBean;
import top.donl.health.model.po.MentalCase;
import top.donl.health.model.query.cases.MentalCaseQuery;
import top.donl.health.model.vo.cases.MentalCaseVO;
import top.donl.util.common.domain.page.PageResult;

public interface MentalCaseService extends IService<MentalCase>{

    MentalCaseVO add(MentalCaseBean bean);
    MentalCaseVO update(MentalCaseBean bean);

    PageResult<MentalCaseVO> list(MentalCaseQuery query);


}
