package top.donl.health;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.donl.bean.util.holder.SpringCtxHolder;
import top.donl.bean.util.log.LogUtil;

/**
 * <p>基础示例-模块分层</p>
 *
 * @author crux
 */


@SpringBootApplication
@MapperScan(basePackages = {
    "top.donl.health.mapper"
})
public class MentalHealthApplication {
    public static void main(String[] args) {
        SpringApplication.run(MentalHealthApplication.class, args);
        LogUtil.showStartLogDoc(SpringCtxHolder.getEnvironment());
    }
}