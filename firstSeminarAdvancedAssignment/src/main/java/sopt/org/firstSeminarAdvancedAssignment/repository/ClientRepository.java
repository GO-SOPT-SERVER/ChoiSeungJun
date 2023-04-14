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

    public int getAccountBalance(String clientAcountNumber, String password) {
        int clientMoneyAmount = -1;

        for (String accountNumber : clientDB.keySet()) {
            if (accountNumber.equals(clientAcountNumber)) {
                Client clientInfo = clientDB.get(clientAcountNumber);

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
}
