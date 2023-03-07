package top.donl.health.converter;

import org.mapstruct.Mapper;
import top.donl.health.model.bean.anno.AnnoBean;
import top.donl.health.model.po.SysAnno;
import top.donl.health.model.vo.anno.AnnoVO;



@Mapper(componentModel = "spring")
public interface SysAnnoConverter {

    SysAnno bean2Po(AnnoBean bean);

    AnnoVO po2Vo(SysAnno po);
}
