package br.com.desafiospring.desafiospring.exception;

public class UserAlreadyFollowSellerException extends RuntimeException {
    public UserAlreadyFollowSellerException(String message) {
        super(message);
    }
}
