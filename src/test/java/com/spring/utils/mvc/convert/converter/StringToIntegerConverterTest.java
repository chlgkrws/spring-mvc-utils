package com.spring.utils.mvc.convert.converter;

import com.spring.utils.mvc.convert.converter.StringToIntegerConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class StringToIntegerConverterTest {

    @Test
    void 문자열을_정수형으로_변환() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer convert = converter.convert("10");
        Assertions.assertThat(convert).isInstanceOf(Integer.class);
    }



}