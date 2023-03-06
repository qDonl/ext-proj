package top.donl.health.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import top.donl.bean.config.config.WebMvcConfiguration;
import top.donl.health.configurer.interceptor.AuthInterceptor;


@Configuration
public class MentalHealthMvcConfigurer extends WebMvcConfiguration {

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        registry.addInterceptor(authInterceptor())
            .addPathPatterns(
                "/user/**", "/sys-anno/**", "/evaluation/**", "/consult-reply/**",
                "/msg-board/**", "/mental-resource/**", "/case/**", "/consult/**");
    }
}
