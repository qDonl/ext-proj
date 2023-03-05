package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.MentalCaseMapper;
import top.donl.health.model.po.MentalCase;
import top.donl.health.service.MentalCaseService;

@Service
@RequiredArgsConstructor
public class MentalCaseServiceImpl
        extends ServiceImpl<MentalCaseMapper, MentalCase>
        implements MentalCaseService{
}
