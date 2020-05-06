package com.freedom;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LanchoneteApplication {

	public static final DateTimeFormatter FORMATTER_DATE = ofPattern("dd/MM/yyyy");
	public static final DateTimeFormatter FORMATTER_TIME = ofPattern("HH:mm");
	public static final DateTimeFormatter FORMATTER_DATE_TIME = ofPattern("dd/MM/yyyy HH:mm");

	public static void main(String[] args) {
		SpringApplication.run(LanchoneteApplication.class, args);
	}
}
