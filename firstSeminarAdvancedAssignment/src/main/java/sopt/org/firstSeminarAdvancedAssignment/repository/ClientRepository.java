package sopt.org.firstSeminarAdvancedAssignment.repository;

import sopt.org.firstSeminarAdvancedAssignment.domain.Client;

import java.util.LinkedHashMap;
import java.util.Map;

import static sopt.org.firstSeminarAdvancedAssignment.view.TextData.*;

public class ClientRepository {
    private static final Map<String, Client> clientDB = new LinkedHashMap<>();

    public void register(Client client) {
        boolean isDuplicated = false;

        for (String accountNumber : clientDB.keySet()) {
            if (client.getAccountNumber().equals(accountNumber)) {
                isDuplicated = true;
                break;
            }
        }

        if (isDuplicated) {
            throw new IllegalArgumentException(ACCOUNT_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }

        clientDB.put(client.getAccountNumber(), client);
    }

    public int getAccountBalance(String clientAccountNumber, String password) {
        int clientMoneyAmount = -1;

        for (String accountNumber : clientDB.keySet()) {
            if (accountNumber.equals(clientAccountNumber)) {
                Client clientInfo = clientDB.get(clientAccountNumber);

                if (clientInfo.checkPassword(password)) {
                    clientMoneyAmount = clientInfo.getAmount();
                    break;
                } else {
                    throw new IllegalArgumentException(WRONG_PASSWORD_ERROR_MESSAGE);
                }
            }
        }
        if (clientMoneyAmount == -1) throw new IllegalArgumentException(WRONG_ACCOUNT_NUMBER_ERROR_MESSAGE);

        return clientMoneyAmount;
    }

    public int withdrawAccountBalance(String accountNumber, int amount) {
        Client client = clientDB.get(accountNumber);
        int remainAmount = client.withdraw(amount);

        return remainAmount;
    }

    public int deposit(String accountNumber, int depositAmount) {
        validateIsExistAccountNumber(accountNumber);

        Client client = clientDB.get(accountNumber);
        int amountAfterDeposit = client.deposit(depositAmount);

        return amountAfterDeposit;
    }

    private void validateIsExistAccountNumber(String clientAccountNumber) {
        boolean isAccountExist = false;
        for (String accountNumber : clientDB.keySet()) {
            if (accountNumber.equals(clientAccountNumber)) {
                isAccountExist = true;
                break;
            }
        }

        if(!isAccountExist) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_NUMBER_ERROR_MESSAGE);
        }
    }
}
