package sopt.org.firstSeminarAdvancedAssignment.view;

import static sopt.org.firstSeminarAdvancedAssignment.view.message.OutputMessage.*;

public class OutputView {

    // 고객 등록 메세지
    public void printInputClientInfoMessage() {
        printEnter();
        System.out.println(REGISTER_CLIENT_MESSAGE);
    }

    public void printInputAccountNumberForRegisterMessage() {
        System.out.println(INPUT_REGISTER_ACCOUNT_NUMBER_MESSAGE);
    }

    public void printInputBirthForRegisterMessage() {
        System.out.println(INPUT_REGISTER_CLIENT_BIRTH_MESSAGE);
    }

    public void printInputTelNumberForRegisterMessage() {
        System.out.println(INPUT_REGISTER_CLIENT_TEL_MESSAGE);
    }

    public void printInputAddressForRegisterMessage() {
        System.out.println(INPUT_REGISTER_CLIENT_ADDRESS_MESSAGE);
    }

    public void printInputPasswordForRegisterMessage() {
        System.out.println(INPUT_REGISTER_CLIENT_PASSWORD_MESSAGE);
    }


    //잔액 조회 메세지
    public void printCheckAccountBalanceMessage() {
        printEnter();
        System.out.println(CHECK_ACCOUNT_BALANCE_MESSAGE);
    }

    public void printClientAmountBalance(int amount) { //! 메서드명 수정 필요
        System.out.printf(CLIENT_ACCOUNT_BALANCE_AMOUNT_MESSAGE, amount);
        printEnter();
    }

    //출금 메세지
    public void printWithdrawAccountBalanceMessage() {
        printEnter();
        System.out.println(CLIENT_WITHDRAW_MESSAGE);
    }

    public void printWithdrawAmountMessage() {
        System.out.println(INPUT_WITHDRAW_AMOUNT_MESSAGE);
    }

    public void printRemainAmountAfterWithdrawMessage(int amount) {
        System.out.printf(WITHDRAW_SUCCESS_MESSAGE, amount);
    }

    //입금 메세지
    public void printDepositIntoAccountMessage() {
        printEnter();
        System.out.println(CLIENT_DEPOSIT_MESSAGE);
    }

    public void printDepositMoneyAmountMessage() {
        System.out.println(INPUT_DEPOSIT_AMOUNT_MESSAGE);
    }

    public void printAmountAfterDeposit(int amount) {
        System.out.printf(DEPOSIT_SUCCESS_MESSAGE, amount);
        printEnter();
    }

    //송금 메세지
    public void printAnotherAccountToTransferMoneyMessage() {
        System.out.println(CLIENT_TRANSFER_MESSAGE);
    }

    public void printTransferAmountMessage() {
        System.out.println(INPUT_TRANSFER_AMOUNT_MESSAGE);
    }

    public void printRemainAmountAfterTransferMessage(int amount) {
        System.out.printf(TRANSFER_SUCCESS_MESSAGE,amount);
        printEnter();
    }


    //기본 메세지
    public void printInputClientNameMessage() {
        System.out.println(INPUT_CLIENT_NAME_MESSAGE);
    }

    public void printInputAccountNumberMessage() {
        System.out.println(INPUT_ACCOUNT_NUMBER_MESSAGE);
    }

    public void printInputPasswordMessage() {
        System.out.println(INPUT_ACCOUNT_PASSWORD_MESSAGE);
    }

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    public void printInputBankingJobMessage() {
        printEnter();
        System.out.println(INPUT_BANKING_JOB_MESSAGE);
    }

    private void printEnter() {
        System.out.println();
    }

    public static void printError(Exception error) {
        System.out.println(error.getMessage());
    }
}
