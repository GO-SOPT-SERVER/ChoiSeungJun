package sopt.org.firstSeminarAdvancedAssignment.controller;

import sopt.org.firstSeminarAdvancedAssignment.service.ClientService;
import sopt.org.firstSeminarAdvancedAssignment.view.InputView;
import sopt.org.firstSeminarAdvancedAssignment.view.OutputView;

public class ClientController extends Controller {
    private final ClientService clientService = new ClientService();

    public ClientController() {
        super(new InputView(), new OutputView());
    }

    public void enter() {
        outputView.printWelcomeMessage();
    }

    public void goOut() {
        outputView.printExitMessage();
    }



    public void registerClient() {
        clientService.registerClient(inputView.inputAccountNumberForClientRegister(), inputView.inputClientName(), inputView.inputBirthForClientRegister(), inputView.inputTelForClientRegister(), inputView.inputAddressForClientRegister(), inputView.inputPasswordForClientRegister());
    }

    public void getClientAccountBalance() {
        outputView.printCheckAccountBalanceMessage();
        int clientAmountBalance = clientService.checkAccountBalance(inputView.inputAccountNumber(), inputView.inputPassword());

        outputView.printClientAmountBalance(clientAmountBalance);
    }

    public void withdrawAccountBalance() {
        outputView.printWithdrawAccountBalanceMessage();

        String accountNumber = inputView.inputAccountNumber();
        String password = inputView.inputPassword();
        int withdrawAccount = inputView.inputWithdrawAccount();


        int remainAmount = clientService.withdrawFromClientAccount(accountNumber, password, withdrawAccount);
        outputView.printRemainAmountAfterWithdrawMessage(remainAmount);
    }

    public void depositMoneyIntoAccount() {
        outputView.printDepositIntoAccountMessage();

        int nowAmount = clientService.depositIntoAccount(inputView.inputAccountNumber(), inputView.inputDepositMoney());
        outputView.printAmountAfterDeposit(nowAmount);
    }

    public void transferMoneyToAnotherAccount() {

        int remainAmount = clientService.transferMoney(
                inputView.inputAccountNumber(), 
                inputView.inputPassword(), 
                inputView.inputAnotherAccountNumber(), 
                inputView.inputTransferMoneyAmount()
            );
        outputView.printRemainAmountAfterTransferMessage(remainAmount);
    }

    public String selectBankJob() {
        String bankingJob = inputView.inputBankingJob();

        return bankingJob;
    }



}
