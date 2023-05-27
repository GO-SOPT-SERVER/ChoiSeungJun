package sopt.org.fourthSeminar.controller.exception.model;

import sopt.org.fourthSeminar.controller.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
