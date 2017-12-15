package ua.com.hav.boot.bootjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJspApplication.class, args);
	}

//	@Bean //this could be provided via auto-configuration
//	MethodValidationPostProcessor methodValidationPostProcessor() {
//		return new MethodValidationPostProcessor();
//	}

}
