package com.tarasiuk.movieland.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AuthRequestDTO {
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String login;
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String password;
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private String token;
    private int userId;
    private long loginTimestamp;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(long loginTimestamp) {
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
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                ", loginTimestamp=" + loginTimestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
