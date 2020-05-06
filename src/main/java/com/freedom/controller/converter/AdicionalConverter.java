package com.freedom.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.freedom.model.Adicional;

@Component
public final class AdicionalConverter implements Converter<String, Adicional> {

    @Override
    public Adicional convert(String source) {
    	if(StringUtils.isEmpty(source)) return null;
    	
    	Adicional a = new Adicional();
    	a.setCodigo(Long.valueOf(source));
        return a;
    }
}