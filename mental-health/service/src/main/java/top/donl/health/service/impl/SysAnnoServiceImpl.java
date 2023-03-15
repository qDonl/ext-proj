package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.converter.SysAnnoConverter;
import top.donl.health.mapper.SysAnnoMapper;
import top.donl.health.model.bean.anno.AnnoBean;
import top.donl.health.model.po.SysAnno;
import top.donl.health.model.vo.anno.AnnoVO;
import top.donl.health.service.SysAnnoService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysAnnoServiceImpl
        extends ServiceImpl<SysAnnoMapper, SysAnno>
        implements SysAnnoService{

    private final SysAnnoConverter sysAnnoConverter;

    @Override
    public AnnoVO addAnno(AnnoBean bean) {
        SysAnno po = sysAnnoConverter.bean2Po(bean);
        baseMapper.insert(po);
        return sysAnnoConverter.po2Vo(po);
    }

    @Override
    public AnnoVO updateAnno(AnnoBean bean) {
        SysAnno po = sysAnnoConverter.bean2Po(bean);
        baseMapper.updateById(po);
        return sysAnnoConverter.po2Vo(po);
    }

    @Override
    public PageResult<AnnoVO> list(BaseQuery query) {
        long total = baseMapper.findTotalCount();
        if (total == 0) {
            return PageResult.toPageResult(null, query, total);
        }

        List<AnnoVO> list = baseMapper.findAnnoList(query);
        return PageResult.toPageResult(list, query, total);
    }
}
