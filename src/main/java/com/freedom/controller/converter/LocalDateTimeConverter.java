package com.freedom.controller.converter;

import java.time.LocalDateTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.freedom.LanchoneteApplication;

@Component
public final class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalDateTime.parse(source, LanchoneteApplication.FORMATTER_DATE_TIME);
    }
}