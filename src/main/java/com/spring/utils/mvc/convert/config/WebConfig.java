package com.spring.utils.mvc.convert.config;

import com.spring.utils.mvc.convert.converter.IntegerToStringConverter;
import com.spring.utils.mvc.convert.converter.IpPortToStringConverter;
import com.spring.utils.mvc.convert.converter.StringToIntegerConverter;
import com.spring.utils.mvc.convert.converter.StringToIpPortConverter;
import com.spring.utils.mvc.convert.formatter.NumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new IpPortToStringConverter());
//        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new StringToIpPortConverter());

        // 위에서 주석처리한 String, Integer Converter은 등록할 포맷터와 기능이 겹치기때문에 주석처리함.
        // 컨버터와 포맷터의 우선순위는 컨버터가 높다.(더 자세하게 타입을 명시를 했기 때문이라고 생각)
        registry.addFormatter(new NumberFormatter());
    }
}
