package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.cache.SessionCache;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import com.tarasiuk.movieland.utils.AllowedRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MovielandInterceptor extends HandlerInterceptorAdapter {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionCache sessionCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Pre-Check of user roles");
        String authToken = request.getHeader("authToken");

        final Method method = ((HandlerMethod) handler).getMethod();

        if (method.isAnnotationPresent(AllowedRoles.class)) {
            String[] allowedRoles = method.getAnnotation(AllowedRoles.class).roles();
            log.info("allowedRoles = " + Arrays.asList(allowedRoles) + "\n" + "token:" + authToken);
            if (authToken == null || !(sessionCache.isUserRoleByToken(authToken, allowedRoles))) {
                throw new RestrictAccessException("Access denied. Wrong credentials");
            }
        }
        return super.preHandle(request, response, handler);
    }
}
