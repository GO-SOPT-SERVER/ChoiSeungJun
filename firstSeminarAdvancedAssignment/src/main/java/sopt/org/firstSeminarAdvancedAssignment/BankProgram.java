package sopt.org.firstSeminarAdvancedAssignment;

import sopt.org.firstSeminarAdvancedAssignment.controller.ClientController;

import static sopt.org.firstSeminarAdvancedAssignment.view.OutputView.printError;
import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.WRONG_BANKING_JOB_ERROR_MESSAGE;
import static sopt.org.firstSeminarAdvancedAssignment.view.message.ErrorMessage.createErrorMessage;

public class BankProgram {
    private static final String FUNC_REGISTER = "1";
    private static final String FUNC_SHOW = "2";
    private static final String FUNC_WITHDRAW = "3";
    private static final String FUNC_DEPOSIT = "4";
    private static final String FUNC_TRANSFER = "5";
    private static final String FUNC_EXIT = "x";

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
            case FUNC_REGISTER:
                clientController.registerClient();
                break;
            case FUNC_SHOW:
                clientController.getClientAccountBalance();
                break;
            case FUNC_WITHDRAW:
                clientController.withdrawAccountBalance();
                break;
            case FUNC_DEPOSIT:
                clientController.depositMoneyIntoAccount();
                break;
            case FUNC_TRANSFER:
                clientController.transferMoneyToAnotherAccount();
                break;
            case FUNC_EXIT:
                isRun = false;
                clientController.goOut();
                break;
            default:
                throw new IllegalArgumentException(createErrorMessage(WRONG_BANKING_JOB_ERROR_MESSAGE));
        }

        return isRun;
    }


}
