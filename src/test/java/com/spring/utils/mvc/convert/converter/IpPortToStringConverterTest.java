package com.spring.utils.mvc.convert.converter;

import com.spring.utils.mvc.convert.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IpPortToStringConverterTest {

    @Test
    void IpPort객체를_문자열로_변환() {
        IpPortToStringConverter converter = new IpPortToStringConverter();

        IpPort ipPort = new IpPort("localhost", 8080);
        String convert = converter.convert(ipPort);

        Assertions.assertThat(convert).isEqualTo("localhost:8080");

    }

    @Test
    void 문자열을_IpPort로_변환() {
        StringToIpPortConverter converter = new StringToIpPortConverter();

        IpPort convert = converter.convert("localhost:8080");

        Assertions.assertThat(convert).isEqualTo(new IpPort("localhost", 8080));

    }
}