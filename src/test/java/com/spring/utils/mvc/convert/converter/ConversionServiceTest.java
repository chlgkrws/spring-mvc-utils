package com.spring.utils.mvc.convert.converter;

import com.spring.utils.mvc.convert.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService() {

        //컨버터 등록
        DefaultConversionService conversionService = new DefaultConversionService();

        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());

        Integer convert = conversionService.convert("10", Integer.class);
        System.out.println("convert = " + convert);

        IpPort convert1 = conversionService.convert("localhost:8080", IpPort.class);
        System.out.println("convert1 = " + convert1);





    }
}
