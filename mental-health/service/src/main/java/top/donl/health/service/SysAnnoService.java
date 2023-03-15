package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.checkerframework.checker.units.qual.A;
import top.donl.health.model.bean.anno.AnnoBean;
import top.donl.health.model.po.SysAnno;
import top.donl.health.model.vo.anno.AnnoVO;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;

public interface SysAnnoService extends IService<SysAnno>{

    AnnoVO addAnno(AnnoBean bean);

    AnnoVO updateAnno(AnnoBean bean);

    PageResult<AnnoVO> list(BaseQuery query);

}
