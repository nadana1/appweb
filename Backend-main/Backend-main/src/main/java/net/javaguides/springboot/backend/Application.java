package net.javaguides.springboot.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"net.javaguides.springboot.backend.controller","net.javaguides.springboot.backend.model","net.javaguides.springboot.backend.repository"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
