package sopt.org.firstSeminarAdvancedAssignment.repository;

import sopt.org.firstSeminarAdvancedAssignment.domain.Client;

import java.util.LinkedHashMap;
import java.util.Map;

import static sopt.org.firstSeminarAdvancedAssignment.view.TextData.ACCOUNT_NUMBER_DUPLICATED_ERROR_MESSAGE;

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
}
