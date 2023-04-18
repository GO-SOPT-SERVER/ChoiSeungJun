package sopt.org.firstSeminarAdvancedAssignment.repository;

import sopt.org.firstSeminarAdvancedAssignment.domain.Client;

import java.util.LinkedHashMap;
import java.util.Map;

import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.*;

public class ClientRepository {
    private static final Map<String, Client> clientDB = new LinkedHashMap<>();

    public void register(Client registerClient) {
        String accountNumber = registerClient.getAccountNumber();
        validateIsDuplicatedAccountNumber(accountNumber);

        clientDB.put(accountNumber, registerClient);
    }

    public int getAccountBalance(String clientAccountNumber, String password) {
        validateIsExistAccountNumber(clientAccountNumber);

        Client client = clientDB.get(clientAccountNumber);
        validateClientPassword(password, client);

        int amount = client.getAmount();
        return amount;
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

    public int transfer(String accountNumber, String password, String anotherAccountNumber, int transferAmount) {
        validateIsExistAccountNumber(accountNumber);
        Client fromClient = clientDB.get(accountNumber);
        validateClientPassword(password, fromClient); //Client 도메인 측으로 넘겨야하는 검증 기능
        
        int remainAmount = fromClient.transfer(transferAmount);

        validateIsExistAccountNumber(anotherAccountNumber);
        Client toClient = clientDB.get(anotherAccountNumber);
        
        toClient.deposit(transferAmount);

        return remainAmount;
    }


    private void validateIsExistAccountNumber(String clientAccountNumber) {
        boolean isAccountExist = false;
        for (String accountNumber : clientDB.keySet()) {
            if (accountNumber.equals(clientAccountNumber)) {
                isAccountExist = true;
                break;
            }
        }
        if (!isAccountExist) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateIsDuplicatedAccountNumber(String clientAccountNumber) {
        for (String accountNumber : clientDB.keySet()) {
            if (accountNumber.equals(clientAccountNumber)) {
                throw new IllegalArgumentException(ACCOUNT_NUMBER_DUPLICATED_ERROR_MESSAGE);
            }
        }
    }

    private void validateClientPassword(String password, Client client) {
        if (!client.checkPassword(password)) {
            throw new IllegalArgumentException(WRONG_PASSWORD_ERROR_MESSAGE);
        }
    }
}
