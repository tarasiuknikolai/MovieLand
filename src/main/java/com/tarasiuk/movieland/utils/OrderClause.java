package com.tarasiuk.movieland.utils;

public enum OrderClause {
    ASC ("ASC"),
    DESC ("DESC");

    private String orderClause;

    OrderClause(String orderClause) {
        this.orderClause = orderClause;
    }

    public String getOrderClause() {
        return orderClause;
    }
}