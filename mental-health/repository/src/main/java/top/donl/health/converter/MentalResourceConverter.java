package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.resource.MentalResourceBean;
import top.donl.health.model.po.MentalResource;
import top.donl.health.model.vo.resource.MentalResourceVO;


@Mapper(componentModel = "spring")
public interface MentalResourceConverter {

    MentalResource bean2Po(MentalResourceBean bean);

    MentalResourceVO po2Vo(MentalResource po);
}
