package sopt.org.thirdSeminarAdvancedAssignment.exception.model;

import sopt.org.thirdSeminarAdvancedAssignment.exception.Error;

public class NotFoundException extends CustomException{
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
