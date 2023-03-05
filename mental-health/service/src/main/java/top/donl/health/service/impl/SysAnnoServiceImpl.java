package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.SysAnnoMapper;
import top.donl.health.model.po.SysAnno;
import top.donl.health.service.SysAnnoService;

@Service
@RequiredArgsConstructor
public class SysAnnoServiceImpl
        extends ServiceImpl<SysAnnoMapper, SysAnno>
        implements SysAnnoService{
}
