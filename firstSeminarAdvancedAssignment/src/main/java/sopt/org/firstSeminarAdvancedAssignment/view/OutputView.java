package sopt.org.firstSeminarAdvancedAssignment.view;

import static sopt.org.firstSeminarAdvancedAssignment.view.message.OutputMessage.*;

public class OutputView {

    // 고객 등록 메세지
    public void printInputClientInfoMessage() {
        printEnter();
        println(REGISTER_CLIENT_MESSAGE);
    }

    public void printInputAccountNumberForRegisterMessage() {
        println(INPUT_REGISTER_ACCOUNT_NUMBER_MESSAGE);
    }

    public void printInputBirthForRegisterMessage() {
        println(INPUT_REGISTER_CLIENT_BIRTH_MESSAGE);
    }

    public void printInputTelNumberForRegisterMessage() {
        println(INPUT_REGISTER_CLIENT_TEL_MESSAGE);
    }

    public void printInputAddressForRegisterMessage() {
        println(INPUT_REGISTER_CLIENT_ADDRESS_MESSAGE);
    }

    public void printInputPasswordForRegisterMessage() {
        println(INPUT_REGISTER_CLIENT_PASSWORD_MESSAGE);
    }


    //잔액 조회 메세지
    public void printCheckAccountBalanceMessage() {
        printEnter();
        println(CHECK_ACCOUNT_BALANCE_MESSAGE);
    }

    public void printClientAmountBalance(int amount) { //! 메서드명 수정 필요
        printf(CLIENT_ACCOUNT_BALANCE_AMOUNT_MESSAGE, amount);
    }

    //출금 메세지
    public void printWithdrawAccountBalanceMessage() {
        printEnter();
        println(CLIENT_WITHDRAW_MESSAGE);
    }

    public void printWithdrawAmountMessage() {
        println(INPUT_WITHDRAW_AMOUNT_MESSAGE);
    }

    public void printRemainAmountAfterWithdrawMessage(int amount) {
        printf(WITHDRAW_SUCCESS_MESSAGE, amount);
    }

    //입금 메세지
    public void printDepositIntoAccountMessage() {
        printEnter();
        println(CLIENT_DEPOSIT_MESSAGE);
    }

    public void printDepositMoneyAmountMessage() {
        println(INPUT_DEPOSIT_AMOUNT_MESSAGE);
    }

    public void printAmountAfterDeposit(int amount) {
        printf(DEPOSIT_SUCCESS_MESSAGE, amount);
    }

    //송금 메세지
    public void printAnotherAccountToTransferMoneyMessage() {
        println(CLIENT_TRANSFER_MESSAGE);
    }

    public void printTransferAmountMessage() {
        println(INPUT_TRANSFER_AMOUNT_MESSAGE);
    }

    public void printRemainAmountAfterTransferMessage(int amount) {
        printf(TRANSFER_SUCCESS_MESSAGE,amount);
    }


    //기본 메세지
    public void printInputClientNameMessage() {
        println(INPUT_CLIENT_NAME_MESSAGE);
    }

    public void printInputAccountNumberMessage() {
        println(INPUT_ACCOUNT_NUMBER_MESSAGE);
    }

    public void printInputPasswordMessage() {
        println(INPUT_ACCOUNT_PASSWORD_MESSAGE);
    }

    public void printWelcomeMessage() {
        println(WELCOME_MESSAGE);
    }

    public void printExitMessage() {
        println(EXIT_MESSAGE);
    }

    public void printInputBankingJobMessage() {
        printEnter();
        println(INPUT_BANKING_JOB_MESSAGE);
    }

    private static void printEnter() {
        println("");
    }
    
    private static void println(String message) {
        System.out.println(message);
    }

    private static void printf(String message, int param) {
        System.out.printf(message,param);
        printEnter();
    }

    public static void printError(Exception error) {
        println(error.getMessage());
    }
}
