package com.spring.utils.mvc.convert.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {


    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        conversionService.addFormatter(new NumberFormatter());

        Number convert = conversionService.convert("1,000", Number.class);
        Assertions.assertThat(convert).isEqualTo(1000L);
    }
}
