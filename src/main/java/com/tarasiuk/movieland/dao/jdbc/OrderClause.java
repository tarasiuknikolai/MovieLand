package com.tarasiuk.movieland.dao.jdbc;

public enum OrderClause {
    ASC,
    DESC;

    public static boolean contains(String orderClause4Check) {
        for (OrderClause orderClause : OrderClause.values()) {
            if (orderClause.name().equalsIgnoreCase(orderClause4Check)) {
                return true;
            }
        }
        return false;
    }
}