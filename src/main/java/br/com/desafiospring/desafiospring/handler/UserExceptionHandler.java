package br.com.desafiospring.desafiospring.handler;

import br.com.desafiospring.desafiospring.exception.MessageError;
import br.com.desafiospring.desafiospring.exception.UserAlreadyFollowSellerException;
import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserDoesNotExistingException.class)
    public ResponseEntity<MessageError> notFoundUser(UserDoesNotExistingException e) {
        MessageError messageError = new MessageError(e.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFollowSellerException.class)
    public ResponseEntity userAlreadyFollowSeller(UserAlreadyFollowSellerException e) {
        MessageError messageError = new MessageError(e.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
