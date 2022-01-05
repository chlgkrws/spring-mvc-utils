package com.spring.utils.mvc.convert.config;

import com.spring.utils.mvc.convert.converter.IntegerToStringConverter;
import com.spring.utils.mvc.convert.converter.IpPortToStringConverter;
import com.spring.utils.mvc.convert.converter.StringToIntegerConverter;
import com.spring.utils.mvc.convert.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new StringToIpPortConverter());
    }
}
