package com.spring.utils.mvc.convert.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class NumberFormatter implements Formatter<Number> {

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("test={}, locale={}",text, locale);

        NumberFormat numberInstance = NumberFormat.getInstance(locale);

        return numberInstance.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);

        NumberFormat instance = NumberFormat.getInstance();

        return instance.format(object);
    }
}
