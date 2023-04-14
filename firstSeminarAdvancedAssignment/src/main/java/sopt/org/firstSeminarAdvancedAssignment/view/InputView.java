package sopt.org.firstSeminarAdvancedAssignment.view;

import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);
    private final OutputView outputView = new OutputView();

    public String inputAccountNumber() {
        outputView.inputAccountNumberForRegisterMessage();
        return inputString();
    }

    public String inputClientName() {
        outputView.inputClientNameForRegisterMessage();
        return inputString();
    }

    public String inputPassword() {
        outputView.inputPasswordForRegisterMessage();
        return inputString();
    }

    public String inputBirth() {
        outputView.inputBirthForRegisterMessage();
        return inputString();
    }

    public String inputTel() {
        outputView.inputTelNumberForRegisterMessage();
        return inputString();
    }

    public String inputAddress() {
        outputView.inputAddressForRegisterMessage();
        return inputString();
    }


    private String inputString() {
        return sc.nextLine();
    }
}
