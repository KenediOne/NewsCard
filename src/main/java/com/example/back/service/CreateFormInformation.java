package com.example.back.service;

import com.example.back.model.dto_data.Information;
import com.example.back.model.request_data.News;

import java.util.List;


public interface CreateFormInformation {

    List<Information> listInformation(News news, String page, String sort );
}
