package com.spring.utils.mvc.convert.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberFormatterTest {

    @Test
    void parse() throws ParseException {
        NumberFormatter numberFormatter = new NumberFormatter();
        Number parse = numberFormatter.parse("1,000", Locale.KOREA);

        assertThat(parse).isInstanceOf(Number.class);
        assertThat(parse).isEqualTo(1000L);
        System.out.println("parse = " + parse);
    }

    @Test
    void print() {

        NumberFormatter numberFormatter = new NumberFormatter();
        String print = numberFormatter.print(1000, Locale.KOREA);

        assertThat(print).isEqualTo("1,000");
        System.out.println("print = " + print);
    }

}