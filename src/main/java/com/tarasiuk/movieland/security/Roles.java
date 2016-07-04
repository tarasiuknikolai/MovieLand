package com.tarasiuk.movieland.security;

public enum Roles {

    GUEST("GUEST"),
    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    public static Roles getRole (String role) {
        for (Roles roles : Roles.values()) {
            if (roles.name().equalsIgnoreCase(role)) {
                return roles;
            }
        }
        throw new IllegalArgumentException("Incorrect Role Name");
    }

}
