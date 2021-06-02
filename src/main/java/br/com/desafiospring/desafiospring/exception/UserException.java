package br.com.desafiospring.desafiospring.exception;

public class UserException extends RuntimeException{
    public UserException(String message) {
        super(message);
    }
}
