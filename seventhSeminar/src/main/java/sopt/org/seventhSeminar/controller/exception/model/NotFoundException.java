package sopt.org.seventhSeminar.controller.exception.model;


import sopt.org.seventhSeminar.controller.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}