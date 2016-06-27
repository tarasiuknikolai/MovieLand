package com.tarasiuk.movieland.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class ResponseFormatConfigurator extends WebMvcConfigurerAdapter {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(false).
                useJaf(true).
                defaultContentType(MediaType.APPLICATION_JSON_UTF8).
                mediaType("json", MediaType.APPLICATION_JSON_UTF8).
                mediaType("xml", MediaType.APPLICATION_XML);
    }
}