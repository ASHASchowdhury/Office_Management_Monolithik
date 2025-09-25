package com.OfficeManagement.OfficeProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@SpringBootApplication
@CrossOrigin(origins = "http://10.0.6.1:3000")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class OfficeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeProjectApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of("system"); // Default user for created_by
	}
}