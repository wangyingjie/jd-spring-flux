package com.jd.flux.startup;

import com.jd.flux.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ComponentScan("com.jd.flux")
@Import(WebConfig.class)
public class JdSpringFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdSpringFluxApplication.class, args);
	}
}
