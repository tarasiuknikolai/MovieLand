package com.tarasiuk.movieland.dto;

public class SimpleResponseDTO {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SimpleResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
