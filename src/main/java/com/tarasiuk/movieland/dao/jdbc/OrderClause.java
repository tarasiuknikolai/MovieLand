package com.tarasiuk.movieland.dao.jdbc;

public enum OrderClause {
    ASC,
    DESC;

    public static boolean contains(String orderClause) {
        for (OrderClause c : OrderClause.values()) {
            if (c.name().equalsIgnoreCase(orderClause)) {
                return true;
            }
        }
        return false;
    }
}