package com.example.back.client.impl;

import com.example.back.client.RestTemplate;
import com.example.back.model.request_data.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

public class RestTemplateImpl implements RestTemplate {

    private final WebClient client;

    @Autowired
    public RestTemplateImpl( String urlAddress ) {
        this.client = WebClient.create( urlAddress );
    }

    @Override
    public News getUserByIdSync() {
        return client
                .get()
                .retrieve()
                .onStatus(HttpStatus::isError, error -> Mono.error( new RuntimeException("API not found") ) )
                .bodyToMono(News.class)
                .block();
    }
}
