package sopt.org.firstSeminarAdvancedAssignment.view;

import java.util.Scanner;

import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.WRONG_NUMBER_FORMAT_ERROR_MESSAGE;

public class InputView {
    private final Scanner sc = new Scanner(System.in);
    private final OutputView outputView = new OutputView();

    public String inputAccountNumberForClientRegister() {
        outputView.printInputClientInfoMessage();
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
        outputView.printDepositMoneyAmountMessage();
        return inputInt();
    }

    public String inputAnotherAccountNumber() {
        outputView.printAnotherAccountToTransferMoneyMessage();
        return inputString();
    }

    public int inputTransferMoneyAmount() {
        outputView.printTransferAmountMessage();
        return inputInt();
    }

    public String inputBankingJob() {
        outputView.printInputBankingJobMessage();
        return inputString();
    }


    private String inputString() {
        return sc.nextLine();
    }

    private Integer inputInt() {
        Integer intValue;
        try {
            intValue = Integer.parseInt(sc.nextLine());
            return intValue;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
