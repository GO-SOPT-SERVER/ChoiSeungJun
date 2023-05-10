package sopt.org.thirdSeminarAdvancedAssignment.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.thirdSeminarAdvancedAssignment.exception.ApiResponse;
import sopt.org.thirdSeminarAdvancedAssignment.exception.Error;
import sopt.org.thirdSeminarAdvancedAssignment.exception.model.ConflictException;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponse.error(Error.REQUEST_VALIDATION_EXCEPTION);
    }

    /*
     * 400 CONFLICT
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler()
    protected ApiResponse handleConflictException(final ConflictException e) {
        return ApiResponse.error(e.getError());
    }


}