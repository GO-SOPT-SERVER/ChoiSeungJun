package sopt.org.firstSeminarAdvancedAssignment.service;

import sopt.org.firstSeminarAdvancedAssignment.domain.Client;
import sopt.org.firstSeminarAdvancedAssignment.repository.ClientRepository;

import static sopt.org.firstSeminarAdvancedAssignment.view.TextData.WRONG_ACCOUNT_BALANCE_AMOUNT_ERROR_MESSAGE;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepository();

    public void registerClient(String accountNumber, String name, String birth, String tel, String address, String password) {
        Client client = new Client(accountNumber, name, birth, tel, address, password);
        clientRepository.register(client);
    }

    public int checkAccountBalance(String accountNumber, String password) {
        return clientRepository.getAccountBalance(accountNumber, password);
    }

    public int withdrawFromClientAccount(String accountNumber, String password, int amount) {
        // 계좌 잔액 체크 및 계좌번호,비밀번호 검증
        int accountBalance = clientRepository.getAccountBalance(accountNumber, password);
        validateAccountBalanceAmount(amount, accountBalance);

        int remainAmount = clientRepository.withdrawAccountBalance(accountNumber, amount);
        return remainAmount;
    }

    public int depositIntoAccount(String accountNumber, int depositAmount) {
        int amountAfterDeposit = clientRepository.deposit(accountNumber, depositAmount);

        return amountAfterDeposit;
    }

    private void validateAccountBalanceAmount(int amount, int accountBalance) {
        if(accountBalance < amount) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_BALANCE_AMOUNT_ERROR_MESSAGE);
        }
    }
}
