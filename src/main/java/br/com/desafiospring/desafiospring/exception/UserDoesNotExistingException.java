package br.com.desafiospring.desafiospring.exception;

public class UserDoesNotExistingException extends RuntimeException {
    public UserDoesNotExistingException(String msg) {
        super(msg);
    }
}
