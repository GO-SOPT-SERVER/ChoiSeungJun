package sopt.org.firstSeminarAdvancedAssignment;

import sopt.org.firstSeminarAdvancedAssignment.controller.ClientController;

import static sopt.org.firstSeminarAdvancedAssignment.view.OutputView.printError;
import static sopt.org.firstSeminarAdvancedAssignment.view.TextData.WRONG_BANKING_JOB_ERROR_MESSAGE;

public class BankProgram {
    private final ClientController clientController = new ClientController();


    public void run() {
        boolean isRun = true;
        clientController.enter();

        while(isRun) {
            try {
                isRun = doBanking();
            } catch (Exception error) {
                printError(error);
            }
        }
    }

    private boolean doBanking() {
        boolean isRun = true;
        switch (clientController.selectBankJob()) {
            case "1":
                clientController.registerClient();
                break;
            case "2":
                clientController.getClientAccountBalance();
                break;
            case "3":
                clientController.withdrawAccountBalance();
                break;
            case "4":
                clientController.depositMoneyIntoAccount();
                break;
            case "5":
                clientController.transferMoneyToAnotherAccount();
                break;
            case "x":
                isRun = false;
                clientController.goOut();
                break;
            default:
                throw new IllegalArgumentException(WRONG_BANKING_JOB_ERROR_MESSAGE);
        }

        return isRun;
    }


}
