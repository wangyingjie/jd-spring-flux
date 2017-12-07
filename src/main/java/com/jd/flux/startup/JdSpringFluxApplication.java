package com.jd.flux.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jd.flux")
public class JdSpringFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdSpringFluxApplication.class, args);
	}
}
