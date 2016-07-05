package com.tarasiuk.movieland.controller.exceptions;

import com.tarasiuk.movieland.dto.SimpleResponseDTO;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class MovielandExceptionControllerAdvice {

    @ExceptionHandler(RestrictAccessException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public SimpleResponseDTO handleRestrictAccessExceptions(RestrictAccessException e) {
        return new SimpleResponseDTO(e.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public SimpleResponseDTO handleSQLExceptions(SQLException e) {
        return new SimpleResponseDTO(e.getMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public SimpleResponseDTO handleNDFExceptions(EmptyResultDataAccessException e) {
        return new SimpleResponseDTO(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public SimpleResponseDTO handleRuntimeExceptions(RuntimeException e) {
        return new SimpleResponseDTO(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public SimpleResponseDTO handleUnknownExceptions(Exception e) {
        return new SimpleResponseDTO(e.getMessage());
    }

}
