package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.ConsultReplyMapper;
import top.donl.health.model.po.ConsultReply;
import top.donl.health.service.ConsultReplyService;
 

@Service
@RequiredArgsConstructor
public class ConsultReplyServiceImpl
        extends ServiceImpl<ConsultReplyMapper, ConsultReply>
        implements ConsultReplyService{

}
