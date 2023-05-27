package sopt.org.seventhSeminar.controller.exception.model;

import sopt.org.seventhSeminar.controller.exception.Error;

public class UnauthorizedException extends SoptException{
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
