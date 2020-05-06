package com.freedom.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.freedom.model.ItemTempero;
import com.freedom.model.Temperos;

@Component
public final class ItemTemperoConverter implements Converter<String, ItemTempero> {

    @Override
    public ItemTempero convert(String source) {
    	if(StringUtils.isEmpty(source)) return null;
    	
    	ItemTempero intemTempero = new ItemTempero();
    	intemTempero.setTempero(Temperos.valueOf(source));
        return intemTempero;
    }
}