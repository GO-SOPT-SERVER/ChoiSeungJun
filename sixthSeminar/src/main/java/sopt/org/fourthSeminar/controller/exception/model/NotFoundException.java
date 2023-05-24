package sopt.org.fourthSeminar.controller.exception.model;


import sopt.org.fourthSeminar.controller.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}