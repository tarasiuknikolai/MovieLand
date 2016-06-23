package com.tarasiuk.movieland.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AuthRequestDTO {
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String login;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String password;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String token;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private Integer userId;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private Long loginTimestamp;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String message;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(Long loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthRequestDTO{" +
                "message='" + message + '\'' +
                ", loginTimestamp=" + loginTimestamp +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
