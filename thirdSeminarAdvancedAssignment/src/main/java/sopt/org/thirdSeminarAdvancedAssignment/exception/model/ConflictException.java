package sopt.org.thirdSeminarAdvancedAssignment.exception.model;

import sopt.org.thirdSeminarAdvancedAssignment.exception.Error;

public class ConflictException extends CustomException{
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
