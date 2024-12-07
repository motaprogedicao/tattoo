package com.tattoo.tattoo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TattooAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TattooAppApplication.class, args);
	}

}
