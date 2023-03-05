package top.donl.health.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.donl.health.model.po.Account;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 09:53:16
 */

@Repository
public interface AccountMapper extends BaseMapper<Account> {

    Account findById(Integer accountId);
}
