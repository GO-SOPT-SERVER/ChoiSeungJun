package sopt.org.thirdSeminarAdvancedAssignment.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private final int code;
    private final String message;
    private T data;

    public static ApiResponse success(SuccessStatus successStatus) {
        return new ApiResponse<>(successStatus.getHttpStatus().value(), successStatus.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessStatus successStatus, T data) {
        return new ApiResponse<T>(successStatus.getHttpStatus().value(), successStatus.getMessage(), data);
    }

    public static ApiResponse error(Error error) {
        return new ApiResponse<>(error.getHttpStatus().value(), error.getMessage());
    }
}