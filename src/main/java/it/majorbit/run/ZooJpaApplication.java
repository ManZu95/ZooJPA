package it.majorbit.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "it.majorbit")
@EnableJpaRepositories(value = "it.majorbit.repository")
@EntityScan(value = "it.majorbit.model")
public class ZooJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooJpaApplication.class, args);
	}

}
