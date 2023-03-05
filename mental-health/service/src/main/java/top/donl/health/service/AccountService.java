package top.donl.health.service;


import top.donl.health.model.po.Account;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 10:08:39
 */


public interface AccountService {

    Account findById(Integer id);

    Account useSelect(Integer id);
}
