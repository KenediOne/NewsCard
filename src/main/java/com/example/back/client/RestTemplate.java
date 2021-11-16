package com.example.back.client;

import com.example.back.model.request_data.News;

public interface RestTemplate {

    News getUserByIdSync();

}
