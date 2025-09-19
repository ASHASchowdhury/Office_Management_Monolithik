package com.OfficeManagement.OfficeProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://10.0.6.1:3000")
public class OfficeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeProjectApplication.class, args);
	}

}
