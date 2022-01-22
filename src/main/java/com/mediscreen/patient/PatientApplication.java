package com.mediscreen.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PatientApplication {

	/**
	 * Cette fonction est le point d'entrée du micro-service Patient
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

}
