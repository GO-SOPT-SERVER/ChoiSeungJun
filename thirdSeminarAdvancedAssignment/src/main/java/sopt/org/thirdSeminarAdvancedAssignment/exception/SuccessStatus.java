package sopt.org.thirdSeminarAdvancedAssignment.exception;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    user
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    POST_SUCCESS(HttpStatus.CREATED, "게시물 등록이 완료되었습니다."),
    POST_FIND_SUCCESS(HttpStatus.CREATED, "게시물 조회에 성공하였습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}