package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.donl.health.common.RoleEnum;
import top.donl.health.converter.ScoreConverter;
import top.donl.health.mapper.EvaluationScoreMapper;
import top.donl.health.mapper.UserMapper;
import top.donl.health.model.bean.score.EvaluationScoreBean;
import top.donl.health.model.po.EvaluationScore;
import top.donl.health.model.po.User;
import top.donl.health.model.vo.score.ScoreVO;
import top.donl.health.service.EvaluationScoreService;
import top.donl.util.common.domain.info.UserInfo;
import top.donl.util.holder.UserCtxHolder;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EvaluationScoreServiceImpl
        extends ServiceImpl<EvaluationScoreMapper, EvaluationScore>
        implements EvaluationScoreService {

    private final ScoreConverter scoreConverter;
    private final UserMapper userMapper;

    @Override
    public void add(EvaluationScoreBean bean) {
        EvaluationScore po = scoreConverter.bean2Po(bean);
        baseMapper.insert(po);
    }

    @Override
    public List<ScoreVO> findSelf() {
        Long userId = UserCtxHolder.getUserInfo().getUserId();
        return baseMapper.findSelf(userId);
    }

    @Override
    public List<ScoreVO> findByRealName(String realName) {
        if (StringUtils.isEmpty(realName)) {
            return Lists.newArrayList();
        }

        UserInfo userInfo = UserCtxHolder.getUserInfo();
        User user = userMapper.findById(userInfo.getUserId());
        if (!RoleEnum.ADMIN.getCode().equals(user.getRole())) {
            return Lists.newArrayList();
        }
        return baseMapper.findByRealName(realName);
    }
}
