package br.com.api.fatec.apifatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class ApiFatecApplication {
	
	@RequestMapping("/")
	String home() {
		return "Hello World";
	}
	
	@RequestMapping("/hello")
	String home2() {
		return "hello word 2";
	}
	@RequestMapping("/numero")
	Integer home3() {
		return 2;

	}
	@RequestMapping("/soma")
	Double home4() {
		return 2.2+2;

	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}

}
