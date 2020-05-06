package com.freedom.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.freedom.model.ItemMolho;
import com.freedom.model.Molhos;

@Component
public final class ItemMolhoConverter implements Converter<String, ItemMolho> {

    @Override
    public ItemMolho convert(String source) {
    	if(StringUtils.isEmpty(source)) return null;
    	
    	ItemMolho intemMolho = new ItemMolho();
    	intemMolho.setMolho(Molhos.valueOf(source));
        return intemMolho;
    }
}