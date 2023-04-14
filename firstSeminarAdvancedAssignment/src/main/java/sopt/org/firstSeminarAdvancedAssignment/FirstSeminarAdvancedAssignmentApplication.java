package sopt.org.firstSeminarAdvancedAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sopt.org.firstSeminarAdvancedAssignment.controller.ClientController;

@SpringBootApplication
public class FirstSeminarAdvancedAssignmentApplication {
    private static final ClientController clientController = new ClientController();

    public static void main(String[] args) {
        SpringApplication.run(FirstSeminarAdvancedAssignmentApplication.class, args);
        clientController.registerClient();
        clientController.getClientAccountBalance();
        clientController.withdrawAccountBalance();
    }

}
