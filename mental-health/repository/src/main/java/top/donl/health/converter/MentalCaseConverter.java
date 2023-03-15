package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.cases.MentalCaseBean;
import top.donl.health.model.po.MentalCase;
import top.donl.health.model.vo.cases.MentalCaseVO;

@Mapper(componentModel = "spring")
public interface MentalCaseConverter {

    MentalCase bean2Po(MentalCaseBean bean);

    MentalCaseVO po2Vo(MentalCase po);
}
