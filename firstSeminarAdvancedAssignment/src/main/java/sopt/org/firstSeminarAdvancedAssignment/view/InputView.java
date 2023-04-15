package sopt.org.firstSeminarAdvancedAssignment.view;

import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);
    private final OutputView outputView = new OutputView();

    public String inputAccountNumberForClientRegister() {
        outputView.printInputAccountNumberForRegisterMessage();
        return inputString();
    }

    public String inputClientName() {
        outputView.printInputClientNameMessage();
        return inputString();
    }

    public String inputPasswordForClientRegister() {
        outputView.printInputPasswordForRegisterMessage();
        return inputString();
    }

    public String inputBirthForClientRegister() {
        outputView.printInputBirthForRegisterMessage();
        return inputString();
    }

    public String inputTelForClientRegister() {
        outputView.printInputTelNumberForRegisterMessage();
        return inputString();
    }

    public String inputAddressForClientRegister() {
        outputView.printInputAddressForRegisterMessage();
        return inputString();
    }

    public String inputPassword() {
        outputView.printInputPasswordMessage();
        return inputString();
    }

    public String inputAccountNumber() {
        outputView.printInputAccountNumberMessage();
        return inputString();
    }

    public int inputWithdrawAccount() {
        outputView.printWithdrawAmountMessage();
        return inputInt();
    }

    public int inputDepositMoney() {
        outputView.printDepositAmountMessage();
        return inputInt();
    }


    private String inputString() {
        return sc.nextLine();
    }

    private Integer inputInt() {
        return sc.nextInt();
    }
}
