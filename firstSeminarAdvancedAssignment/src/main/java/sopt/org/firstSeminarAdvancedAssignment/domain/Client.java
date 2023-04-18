package sopt.org.firstSeminarAdvancedAssignment.domain;

import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.*;

public class Client {

    private String accountNumber;
    private String password;
    private int amount;
    private String name;
    private String birth;
    private String tel;
    private String address;


    public Client(String accountNumber, String name, String birth, String tel, String address, String password) {
        validateAccountNumberForRegister(accountNumber);
        this.accountNumber = accountNumber;
        validatePasswordForRegister(password);
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



    private void validateAccountNumberForRegister(String accountNumber) {
        String[] seperatedAccountNumber = accountNumber.split("-");

        validateAccountNumberLength(seperatedAccountNumber);
        validateAccountNumberFormat(seperatedAccountNumber);
    }

    private void validateAccountNumberFormat(String[] seperatedAccountNumber) {
        try {
            for (int i = 0; i < seperatedAccountNumber.length; i++) {
                Integer.parseInt(seperatedAccountNumber[i]);
            }
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_ACCOUNT_NUMBER_FORMAT_ERROR_MESSAGE));
        }
    }

    private void validateAccountNumberLength(String[] seperatedAccountNumber) {
        if (seperatedAccountNumber.length != 3) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_ACCOUNT_NUMBER_FORMAT_ERROR_MESSAGE));
        }
    }

    private void validatePasswordForRegister(String password) {
        validatePasswordNumberFormat(password);
        validatePasswordNumberLength(password);
    }

    private void validatePasswordNumberLength(String password) {
        if(password.length() != 6) {
            throw new IllegalArgumentException(createErrorMessage("비밀번호는 6자로 구성되어야합니다."));
        }
    }

    private void validatePasswordNumberFormat(String password) {
        try {
            Integer.parseInt(password);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(createErrorMessage("비밀번호는 정수형으로 구성되어야합니다."));
        }
    }


    public int transfer(int transferAmount) {
        validateAccountBalanceToTransfer(transferAmount);
        this.amount -= transferAmount;
        return this.amount;
    }

    private void validateAccountBalanceToTransfer(int transferAmount) {
        if (this.amount < transferAmount) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_TRANSFER_AMOUNT_ERROR_MESSAGE));
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
