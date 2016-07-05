package com.tarasiuk.movieland.utils;

import com.tarasiuk.movieland.service.security.Roles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedRoles {
    Roles[] roles();
}
