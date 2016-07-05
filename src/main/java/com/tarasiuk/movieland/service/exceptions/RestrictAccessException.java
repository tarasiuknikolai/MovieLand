package com.tarasiuk.movieland.service.exceptions;

public class RestrictAccessException extends RuntimeException{
    public RestrictAccessException() {
    }

    public RestrictAccessException(String message) {
        super(message);
    }
}
