package top.donl.health.configurer.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "file.config")
public class FileProperty {

    /**
     * 文件夹路径
     */
    private String folder;

    /**
     * 文件服务器域名
     */
    private String domain;

}
