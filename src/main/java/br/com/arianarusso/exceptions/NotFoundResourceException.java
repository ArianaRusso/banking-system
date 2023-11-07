package br.com.arianarusso.exceptions;

public class NotFoundResourceException extends RuntimeException {

    public NotFoundResourceException(String message) {
        super(message);
    }
}
