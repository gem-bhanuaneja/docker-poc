package com.example.Dockerspringboot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "Mobile service Application"), servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class DockerSpringbootRedisPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringbootRedisPostgresApplication.class, args);
	}

}
