package com.freedom.controller.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.freedom.LanchoneteApplication;

@Component
public final class LocalTimeConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalTime.parse(source, LanchoneteApplication.FORMATTER_TIME);
    }
}