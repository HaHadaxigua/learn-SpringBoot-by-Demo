package zrx.springbootinterceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zrx.springbootinterceptor.filter.MyFilter;
import zrx.springbootinterceptor.filter.MyFilter2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 手动配置过滤器
 */
@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;
    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> firstFilter() {
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.setFilter(myFilter);
        filterFilterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/filter/*")));
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> secondFilter() {
        FilterRegistrationBean<MyFilter2> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setOrder(2);
        filterFilterRegistrationBean.setFilter(myFilter2);
        filterFilterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/filter/*")));
        return filterFilterRegistrationBean;
    }
}
