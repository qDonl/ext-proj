package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.donl.health.model.bean.consult.ConsultBean;
import top.donl.health.model.po.Consult;
import top.donl.health.model.query.consult.ConsultQuery;
import top.donl.health.model.vo.consult.ConsultInfoVo;
import top.donl.health.model.vo.consult.ConsultVO;
import top.donl.util.common.domain.page.PageResult;

public interface ConsultService extends IService<Consult>{

    ConsultVO add(ConsultBean bean);
    ConsultVO update(ConsultBean bean);

    PageResult<ConsultVO> list(ConsultQuery query, Boolean isSelf);

    ConsultInfoVo detail(Long consultId);
}
