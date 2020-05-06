package com.freedom.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.freedom.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.freedom.thymeleaf.processor.MessageElementTagProcessor;

@Component
public class LanchoneteDialect extends AbstractProcessorDialect {

	public LanchoneteDialect() {
		super("Home Lanchonete", "lanchonete", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}

}
