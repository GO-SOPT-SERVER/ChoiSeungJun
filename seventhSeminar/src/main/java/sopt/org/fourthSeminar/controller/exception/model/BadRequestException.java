package sopt.org.fourthSeminar.controller.exception.model;

import sopt.org.fourthSeminar.controller.exception.Error;

public class BadRequestException extends SoptException{

    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
