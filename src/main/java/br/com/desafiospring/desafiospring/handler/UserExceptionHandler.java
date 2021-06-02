package br.com.desafiospring.desafiospring.handler;

import br.com.desafiospring.desafiospring.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = {UserDoesNotExistingException.class, UserAlreadyFollowSellerException.class,
            InvalidFollowUserException.class})
    public ResponseEntity getExceptions(UserException e) {
        MessageError messageError = new MessageError(e.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
