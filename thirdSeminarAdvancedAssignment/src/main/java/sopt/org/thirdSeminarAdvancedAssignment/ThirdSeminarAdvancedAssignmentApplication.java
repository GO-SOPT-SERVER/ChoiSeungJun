package sopt.org.thirdSeminarAdvancedAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ThirdSeminarAdvancedAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdSeminarAdvancedAssignmentApplication.class, args);
	}

}
