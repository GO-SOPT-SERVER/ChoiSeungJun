package sopt.org.fourthSeminar.controller.exception.model;

import sopt.org.fourthSeminar.controller.exception.Error;

public class UnauthorizedException extends SoptException{
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
