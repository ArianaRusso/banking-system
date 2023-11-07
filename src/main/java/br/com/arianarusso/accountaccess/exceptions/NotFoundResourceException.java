package br.com.arianarusso.accountaccess.exceptions;

public class NotFoundResourceException extends RuntimeException {

    public NotFoundResourceException(String message) {
        super(message);
    }
}
