package top.donl.health.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.donl.health.mapper.AccountMapper;
import top.donl.health.model.po.Account;
import top.donl.health.service.AccountService;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 10:09:07
 */

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Override
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    @Override
    public Account useSelect(Integer id) {
        return accountMapper.selectById(id);
    }
}
