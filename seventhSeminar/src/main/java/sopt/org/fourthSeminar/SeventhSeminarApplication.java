package sopt.org.fourthSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SeventhSeminarApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeventhSeminarApplication.class, args);
	}

}
