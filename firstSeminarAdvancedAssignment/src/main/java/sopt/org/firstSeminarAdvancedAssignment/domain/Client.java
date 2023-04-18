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
        this.accountNumber = validateAccountNumberForRegister(accountNumber);
        this.password = validatePasswordForRegister(password);
        this.name = name;
        this.birth = validateBirthForRegister(birth);
        this.tel = validateTelForRegister(tel);
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


    private String validateAccountNumberForRegister(String accountNumber) {
        String[] seperatedAccountNumber = accountNumber.split("-");

        validateAccountNumberLength(seperatedAccountNumber);
        validateAccountNumberFormat(seperatedAccountNumber);

        return accountNumber;
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

    private String validatePasswordForRegister(String password) {
        validatePasswordNumberLength(password);
        validatePasswordNumberFormat(password);

        return password;
    }

    private void validatePasswordNumberLength(String password) {
        if (password.length() != 4) {
            throw new IllegalArgumentException(createErrorMessage("비밀번호는 6자로 구성되어야합니다."));
        }
    }

    private void validatePasswordNumberFormat(String password) {
        try {
            Integer.parseInt(password);
        } catch (Exception e) {
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

    private String validateBirthForRegister(String birth) {
        String[] seperatedBirth = birth.split("-");
        validateBirthLength(seperatedBirth);
        validateBirthSizeFormat(seperatedBirth);
        validateBirthTypeFormat(seperatedBirth);

        return birth;
    }

    private void validateBirthTypeFormat(String[] seperatedBirth) {
        try {
            for (int i = 0; i < seperatedBirth.length; i++) {
                Integer.parseInt(seperatedBirth[i]);
            }
        } catch (Exception error) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_BIRTH_FORMAT_ERROR_MESSAGE));
        }
    }

    private void validateBirthSizeFormat(String[] seperatedBirth) {
        int yearLength = seperatedBirth[0].length();
        int monthLength = seperatedBirth[1].length();
        int dayLength = seperatedBirth[2].length();

        if (yearLength != 2 || monthLength != 2 || dayLength != 2) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_BIRTH_FORMAT_ERROR_MESSAGE));
        }
    }

    private void validateBirthLength(String[] seperatedBirth) {
        if (seperatedBirth.length != 3) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_BIRTH_LENGTH_ERROR_MESSAGE));
        }
    }


    private String validateTelForRegister(String tel) {
        String[] seperatedTel = tel.split("-");

        validateTelLength(seperatedTel);
        validateTelSizeFormat(seperatedTel);
        validateTelTypeFormat(seperatedTel);

        return tel;
    }

    private void validateTelTypeFormat(String[] seperatedTel) {
        try {
            for (int i = 0; i < seperatedTel.length; i++) {
                Integer.parseInt(seperatedTel[i]);
            }
        } catch (Exception error) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_TEL_FORMAT_ERROR_MESSAGE));
        }
    }

    private void validateTelSizeFormat(String[] seperatedTel) {
        int firstTelLength = seperatedTel[0].length();
        int middleTelLength = seperatedTel[1].length();
        int lastTelLength = seperatedTel[2].length();

        if (firstTelLength != 3 || middleTelLength != 4 || lastTelLength != 4) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_TEL_FORMAT_ERROR_MESSAGE));
        }
    }

    private void validateTelLength(String[] seperatedTel) {
        if (seperatedTel.length != 3) {
            throw new IllegalArgumentException(createErrorMessage(WRONG_TEL_LENGTH_ERROR_MESSAGE));
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
