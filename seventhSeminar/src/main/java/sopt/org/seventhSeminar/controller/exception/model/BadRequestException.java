package sopt.org.seventhSeminar.controller.exception.model;

import sopt.org.seventhSeminar.controller.exception.Error;

public class BadRequestException extends SoptException{

    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
