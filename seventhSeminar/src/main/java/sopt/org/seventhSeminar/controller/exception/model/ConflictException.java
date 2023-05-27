package sopt.org.seventhSeminar.controller.exception.model;

import sopt.org.seventhSeminar.controller.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
