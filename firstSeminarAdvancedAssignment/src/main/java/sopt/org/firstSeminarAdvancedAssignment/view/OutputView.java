package sopt.org.firstSeminarAdvancedAssignment.view;

public class OutputView {

    public final void inputClientInfoMessage() {
        System.out.println("고객 등록을 위하여, 정보를 입력해주세요.");
    }

    public final void inputAccountNumberForRegisterMessage() {
        System.out.println("등록하실 계좌번호를 입력해주세요. (중복불가)");
    }

    public final void inputClientNameForRegisterMessage() {
        System.out.println("이름을 입력해주세요.");
    }

    public final void inputBirthForRegisterMessage() {
        System.out.println("생년월일을 입력해주세요. (2000-01-01 형식)");
    }

    public final void inputTelNumberForRegisterMessage() {
        System.out.println("전화번호를 입력해주세요. (010-1234-1234 형식)");
    }

    public final void inputAddressForRegisterMessage() {
        System.out.println("거주지 주소를 입력해주세요.");
    }

    public final void inputPasswordForRegisterMessage() {
        System.out.println("사용하실 비밀번호를 입력해주세요.");
    }

}
