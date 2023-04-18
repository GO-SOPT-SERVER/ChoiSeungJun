package sopt.org.firstSeminarAdvancedAssignment.domain;

import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.WRONG_ACCOUNT_NUMBER_FORMAT_ERROR_MESSAGE;
import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.WRONG_TRANSFER_AMOUNT_ERROR_MESSAGE;

public class Client {

    private String accountNumber;
    private String password;
    private int amount;
    private String name;
    private String birth;
    private String tel;
    private String address;


    public Client(String accountNumber, String name, String birth, String tel, String address, String password) {
        checkAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
        this.amount = 0;
    }

    public boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    private void checkAccountNumber(String accountNumber) {
        String[] seperatedAccountNumber = accountNumber.split("-");

        checkAccountNumberLength(seperatedAccountNumber);
        checkAccountNumberFormat(seperatedAccountNumber);
    }

    private void checkAccountNumberFormat(String[] seperatedAccountNumber) {
        try {
            for (int i = 0; i < seperatedAccountNumber.length; i++) {
                Integer.parseInt(seperatedAccountNumber[i]);
            }
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void checkAccountNumberLength(String[] seperatedAccountNumber) {
        if (seperatedAccountNumber.length != 3) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public void checkAccountBalanceToTransfer(int transferAmount) {
        if (this.amount < transferAmount) {
            throw new IllegalArgumentException(WRONG_TRANSFER_AMOUNT_ERROR_MESSAGE);
        }
    }

    public int withdraw(int withdrawAmount) {
        this.amount -= withdrawAmount;
        return this.amount;
    }

    public int deposit(int amount) {
        this.amount += amount;
        return this.amount;
    }
}
