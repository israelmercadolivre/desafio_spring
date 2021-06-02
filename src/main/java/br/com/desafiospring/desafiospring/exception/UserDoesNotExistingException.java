package br.com.desafiospring.desafiospring.exception;

public class UserDoesNotExistingException extends UserException {
    public UserDoesNotExistingException(String msg) {
        super(msg);
    }
}
