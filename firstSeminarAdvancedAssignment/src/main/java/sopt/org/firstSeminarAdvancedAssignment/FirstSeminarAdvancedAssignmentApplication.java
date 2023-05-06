package sopt.org.firstSeminarAdvancedAssignment;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSeminarAdvancedAssignmentApplication {
    public static void main(String[] args) {
        final BankProgram bankProgram = new BankProgram();
        bankProgram.run();
    }

}
