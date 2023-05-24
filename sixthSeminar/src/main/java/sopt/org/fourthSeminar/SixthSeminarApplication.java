package sopt.org.fourthSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SixthSeminarApplication {
	public static void main(String[] args) {
		SpringApplication.run(SixthSeminarApplication.class, args);
	}

}
