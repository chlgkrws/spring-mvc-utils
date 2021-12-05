package com.spring.utils.mvc.config;

import com.spring.utils.mvc.filter.LogFilter;
import com.spring.utils.mvc.interceptor.LogInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.Map;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                //excludePathPatterns을 통해 특정 URI의 인터셉터 동작을 제어할 수 있음
                .excludePathPatterns("/css/**", "/*.ico", "/error", "/error/**");
    }

    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        // DispatcherType.Error를 제외하면, Error에 대해 해당 필터가 동작하지 않음
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);

        // init Parameter
        filterRegistrationBean.setInitParameters(Map.of("key", "value"));

        return filterRegistrationBean;
    }
}
