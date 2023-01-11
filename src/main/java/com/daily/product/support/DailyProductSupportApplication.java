package com.daily.product.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DailyProductSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyProductSupportApplication.class, args);
	}

}
