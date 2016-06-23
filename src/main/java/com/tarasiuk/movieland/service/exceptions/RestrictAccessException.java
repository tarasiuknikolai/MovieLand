package com.tarasiuk.movieland.service.exceptions;

public class RestrictAccessException extends Exception{
    public RestrictAccessException() {
    }

    public RestrictAccessException(String message) {
        super(message);
    }
}
