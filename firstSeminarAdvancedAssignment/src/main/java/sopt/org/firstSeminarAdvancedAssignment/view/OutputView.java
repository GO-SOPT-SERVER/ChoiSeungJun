package sopt.org.firstSeminarAdvancedAssignment.view;

public class OutputView {

    // 고객 등록 메세지
    public final void printInputClientInfoMessage() {
        System.out.println("고객 등록을 위하여, 정보를 입력해주세요.");
    }

    public final void printInputAccountNumberForRegisterMessage() {
        System.out.println("등록하실 계좌번호를 입력해주세요. (중복불가)");
    }

    public final void printInputBirthForRegisterMessage() {
        System.out.println("생년월일을 입력해주세요. (2000-01-01 형식)");
    }

    public final void printInputTelNumberForRegisterMessage() {
        System.out.println("전화번호를 입력해주세요. (010-1234-1234 형식)");
    }

    public final void printInputAddressForRegisterMessage() {
        System.out.println("거주지 주소를 입력해주세요.");
    }

    public final void printInputPasswordForRegisterMessage() {
        System.out.println("사용하실 비밀번호를 입력해주세요.");
    }


    //잔액 조회 메세지
    public final void printCheckAccountBalanceMessage() {
        System.out.println("잔액 조회를 위해 계좌번호와 비밀번호를 입력해주세요.");
    }

    public final void printClientAmountBalance(int amount) {
        System.out.println("해당 계좌의 잔액은 " + amount + "원 입니다.");
    }

    //기본 메세지
    public final void printInputClientNameMessage() {
        System.out.println("이름을 입력해주세요.");
    }

    public final void printInputAccountNumberMessage() {
        System.out.println("계좌번호를 입력해주세요.");
    }

    public final void printInputPasswordMessage() {
        System.out.println("비밀번호를 입력해주세요.");
    }

}
