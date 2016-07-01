package com.tarasiuk.movieland.dto;

public class SimpleResponseDTO {
    private String message;

    public SimpleResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SimpleResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
