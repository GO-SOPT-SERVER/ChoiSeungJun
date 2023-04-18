package sopt.org.firstSeminarAdvancedAssignment.view.message;

public class ErrorMessage {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static final String ACCOUNT_NUMBER_DUPLICATED_ERROR_MESSAGE = "이미 존재하는 계좌번호입니다. 다른 번호를 사용해주세요.";
    public static final String WRONG_PASSWORD_ERROR_MESSAGE = "비밀번호가 틀렸습니다. 다시 시도해주세요.";
    public static final String WRONG_ACCOUNT_NUMBER_ERROR_MESSAGE = "존재하지 않는 계좌번호입니다. 다시 시도해주세요.";
    public static final String WRONG_ACCOUNT_NUMBER_FORMAT_ERROR_MESSAGE = "계좌번호 형식이 잘못되었습니다. 'Integer-Integer-Integer' 형식으로 입력해주세요.";
    public static final String WRONG_ACCOUNT_BALANCE_AMOUNT_ERROR_MESSAGE = "입력하신 금액이 계좌 내의 잔액보다 많습니다. 다시 시도해주세요.";
    public static final String WRONG_TRANSFER_AMOUNT_ERROR_MESSAGE = "계좌 내의 잔액이 송금하실 금액보다 적습니다.";
    public static final String WRONG_NUMBER_FORMAT_ERROR_MESSAGE = "입력하신 값이 숫자형태가 아닙니다. 다시 시도해주세요.";
    public static final String WRONG_BANKING_JOB_ERROR_MESSAGE = "존재하지 않는 기능입니다. 다시 시도해주세요.";

    public static String createErrorMessage(String errorMessage) {
        return ERROR_PREFIX + errorMessage;
    }
}