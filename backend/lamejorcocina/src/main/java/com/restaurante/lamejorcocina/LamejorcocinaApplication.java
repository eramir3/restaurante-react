package com.restaurante.lamejorcocina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LamejorcocinaApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LamejorcocinaApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(LamejorcocinaApplication.class, args);
	}

}
