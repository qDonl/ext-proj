package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.ConsultMapper;
import top.donl.health.model.po.Consult;
import top.donl.health.service.ConsultService;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl
        extends ServiceImpl<ConsultMapper, Consult>
        implements ConsultService{
}
