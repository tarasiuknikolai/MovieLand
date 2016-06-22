package com.tarasiuk.movieland.dto.request;

public class AuthRequestDTO {
    private String login;
    private String password;
    private String token;
    private int userId;
    private long loginTimestamp;

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

    @Override
    public String toString() {
        return "AuthRequestDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                ", loginTimestamp=" + loginTimestamp +
                '}';
    }
}
