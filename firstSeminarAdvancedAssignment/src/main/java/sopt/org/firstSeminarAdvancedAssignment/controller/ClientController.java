package sopt.org.firstSeminarAdvancedAssignment.controller;

import sopt.org.firstSeminarAdvancedAssignment.service.ClientService;
import sopt.org.firstSeminarAdvancedAssignment.view.InputView;
import sopt.org.firstSeminarAdvancedAssignment.view.OutputView;

public class ClientController {
    private final ClientService clientService = new ClientService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void registerClient() {
        outputView.printInputClientInfoMessage();
        clientService.registerClient(inputView.inputAccountNumberForClientRegister(), inputView.inputClientName(), inputView.inputBirthForClientRegister(), inputView.inputTelForClientRegister(), inputView.inputAddressForClientRegister(), inputView.inputPasswordForClientRegister());
    }

    public void getClientAccountBalance() {
        outputView.printCheckAccountBalanceMessage();
        int clientAmountBalance = clientService.checkAccountBalance(inputView.inputAccountNumber(), inputView.inputPassword());

        outputView.printClientAmountBalance(clientAmountBalance);
    }

    public void withdrawAccountBalance() {
        outputView.printWithdrawAccountBalanceMessage();

        int remainAmount = clientService.withdrawFromClientAccount(inputView.inputAccountNumber(), inputView.inputPassword(), inputView.inputWithdrawAccount());
        outputView.printRemainAmountAfterWithdrawMessage(remainAmount);
    }

}
