package top.donl.health.configurer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 10:04:13
 */


@Configuration
@ComponentScan(basePackages = {
        "top.donl.swagger",
        "top.donl.bean.config",
        "top.donl.mybatisplus"
})
public class BaseConfig {
}
