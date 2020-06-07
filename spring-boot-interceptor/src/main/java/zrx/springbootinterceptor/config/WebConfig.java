package zrx.springbootinterceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zrx.springbootinterceptor.interceptor.OldApiInterceptor;
import zrx.springbootinterceptor.interceptor.TestInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).excludePathPatterns("/login", "/index");
        registry.addInterceptor(new OldApiInterceptor()).addPathPatterns("/admin/oldLogin");
    }
}
