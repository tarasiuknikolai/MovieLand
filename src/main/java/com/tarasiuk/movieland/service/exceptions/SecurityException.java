package com.tarasiuk.movieland.service.exceptions;

public class SecurityException extends RuntimeException{

    public SecurityException() {
    }

    public SecurityException(String message) {
        super(message);
    }
}
