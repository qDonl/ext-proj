package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.consult.ConsultBean;
import top.donl.health.model.po.Consult;
import top.donl.health.model.vo.consult.ConsultVO;


@Mapper(componentModel = "spring")
public interface ConsultConverter {

    Consult bean2Po(ConsultBean bean);

    ConsultVO po2Vo(Consult po);
}
