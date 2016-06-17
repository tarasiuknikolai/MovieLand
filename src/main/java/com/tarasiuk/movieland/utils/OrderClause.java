package com.tarasiuk.movieland.utils;

public enum OrderClause {
    ASC ("ASC"),
    DESC ("DESC");

    private String orderClause;

    OrderClause(String orderClause) {
        this.orderClause = orderClause;
    }

    public static boolean contains(String orderClause) {
        for (OrderClause c : OrderClause.values()) {
            if (c.name().equalsIgnoreCase(orderClause)) {
                return true;
            }
        }
        return false;
    }

    public String getOrderClause() {
        return orderClause;
    }
}