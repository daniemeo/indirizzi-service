package it.sogei.svildep.indirizziservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@RequiredArgsConstructor
@SpringBootApplication
public class IndirizziServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndirizziServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
