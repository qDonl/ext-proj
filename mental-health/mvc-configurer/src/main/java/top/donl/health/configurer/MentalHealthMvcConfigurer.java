package top.donl.health.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("POST","GET","PUT","DELETE")
            .maxAge(1800)
            .allowCredentials(true)
            .allowedHeaders("*")
            .exposedHeaders("token");
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
