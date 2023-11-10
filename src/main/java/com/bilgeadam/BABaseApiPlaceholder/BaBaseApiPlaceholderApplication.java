package com.bilgeadam.BABaseApiPlaceholder;

import com.bilgeadam.BABaseApiPlaceholder.service.FakeDataService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaBaseApiPlaceholderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaBaseApiPlaceholderApplication.class, args);
	}

}
