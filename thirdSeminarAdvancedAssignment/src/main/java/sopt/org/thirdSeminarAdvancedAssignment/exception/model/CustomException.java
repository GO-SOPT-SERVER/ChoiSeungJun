package sopt.org.thirdSeminarAdvancedAssignment.exception.model;

import lombok.Getter;
import sopt.org.thirdSeminarAdvancedAssignment.exception.Error;

@Getter
public class CustomException extends RuntimeException{

    private final Error error;

    public CustomException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
