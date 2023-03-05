package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.MentalResourceMapper;
import top.donl.health.model.po.MentalResource;
import top.donl.health.service.MentalResourceService;

@Service
@RequiredArgsConstructor
public class MentalResourceServiceImpl
        extends ServiceImpl<MentalResourceMapper, MentalResource>
        implements MentalResourceService{
}
