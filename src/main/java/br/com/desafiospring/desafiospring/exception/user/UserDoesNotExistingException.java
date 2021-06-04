package br.com.desafiospring.desafiospring.exception.user;

public class UserDoesNotExistingException extends UserException {
    public UserDoesNotExistingException(String msg) {
        super(msg);
    }
}
