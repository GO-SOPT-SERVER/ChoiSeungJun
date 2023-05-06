package sopt.org.firstSeminarAdvancedAssignment.view.message;

public class OutputMessage {

    public final static String REGISTER_CLIENT_MESSAGE = "고객 등록을 위하여, 정보를 입력해주세요.";
    public final static String INPUT_REGISTER_ACCOUNT_NUMBER_MESSAGE = "등록하실 계좌번호를 입력해주세요. (Integer-Integer-Integer 형식)";
    public final static String INPUT_REGISTER_CLIENT_BIRTH_MESSAGE = "생년월일을 입력해주세요. (00-01-01 형식)";
    public final static String INPUT_REGISTER_CLIENT_TEL_MESSAGE = "전화번호를 입력해주세요. (010-1234-1234 형식)";
    public final static String INPUT_REGISTER_CLIENT_ADDRESS_MESSAGE = "거주지 주소를 입력해주세요.";
    public final static String INPUT_REGISTER_CLIENT_PASSWORD_MESSAGE = "사용하실 비밀번호를 입력해주세요. (정수 4글자)";

    public final static String CHECK_ACCOUNT_BALANCE_MESSAGE = "잔액 조회를 위해 계좌번호와 비밀번호를 입력해주세요.";
    public final static String CLIENT_ACCOUNT_BALANCE_AMOUNT_MESSAGE = "해당 계좌의 잔액은 %d원 입니다.";

    public final static String CLIENT_WITHDRAW_MESSAGE = "출금을 위해 계좌번호와 비밀번호를 입력해주세요.";
    public final static String INPUT_WITHDRAW_AMOUNT_MESSAGE = "출금하실 금액을 입력해주세요.";
    public final static String WITHDRAW_SUCCESS_MESSAGE = "출금이 완료되었습니다.\n출금 후 잔액은 %d원 입니다.\n";

    public final static String CLIENT_DEPOSIT_MESSAGE = "입금을 위해 계좌번호를 입력해주세요.";
    public final static String INPUT_DEPOSIT_AMOUNT_MESSAGE = "입금하실 금액을 입력해주세요.";
    public final static String DEPOSIT_SUCCESS_MESSAGE = "입금이 완료되었습니다.\n입금 후 계좌 내 금액은 %d원 입니다.\n";

    public final static String CLIENT_TRANSFER_MESSAGE = "돈을 송금할 계좌번호를 입력해주세요.";
    public final static String INPUT_TRANSFER_AMOUNT_MESSAGE = "송금하실 금액을 입력해주세요.";
    public final static String TRANSFER_SUCCESS_MESSAGE = "송금이 완료되었습니다.\n송금 후 계좌 내 금액은 %d원 입니다.\n";


    public final static String INPUT_CLIENT_NAME_MESSAGE = "이름을 입력해주세요.";
    public final static String INPUT_ACCOUNT_NUMBER_MESSAGE = "계좌번호를 입력해주세요.";
    public final static String INPUT_ACCOUNT_PASSWORD_MESSAGE = "비밀번호를 입력해주세요.";
    public final static String WELCOME_MESSAGE = "반갑습니다 SOPT은행입니다. 무엇을 도와드릴까요?";
    public final static String EXIT_MESSAGE = "안녕히가십시오.";
    public final static String INPUT_BANKING_JOB_MESSAGE = "은행 업무를 선택해주세요\n" +
            "- 1: 계좌등록\n" +
            "- 2: 잔액조회\n" +
            "- 3: 출금\n" +
            "- 4: 입금\n" +
            "- 5: 송급\n" +
            "- x: 종료";






}
