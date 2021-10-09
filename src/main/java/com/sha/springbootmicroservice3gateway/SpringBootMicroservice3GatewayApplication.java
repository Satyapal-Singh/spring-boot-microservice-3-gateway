package com.sha.springbootmicroservice3gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@OpenAPIDefinition(info = @Info(title = "Gateway API", version = "3.0.1", description = "Gateway APIs"))
public class SpringBootMicroservice3GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice3GatewayApplication.class, args);
	}

}
