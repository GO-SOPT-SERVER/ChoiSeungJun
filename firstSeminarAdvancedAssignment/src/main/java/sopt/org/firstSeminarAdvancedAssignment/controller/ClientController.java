package sopt.org.firstSeminarAdvancedAssignment.controller;

import sopt.org.firstSeminarAdvancedAssignment.service.ClientService;
import sopt.org.firstSeminarAdvancedAssignment.view.InputView;
import sopt.org.firstSeminarAdvancedAssignment.view.OutputView;

public class ClientController {
    private final ClientService clientService = new ClientService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void registerClient() {
        outputView.inputClientInfoMessage();
        clientService.registerClient(inputView.inputAccountNumber(), inputView.inputClientName(), inputView.inputBirth(), inputView.inputTel(), inputView.inputAddress(), inputView.inputPassword());
    }

}
