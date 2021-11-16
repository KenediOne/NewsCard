package com.example.back.service;

import com.example.back.model.dto_data.Information;

import java.util.List;

public interface NewsService {

    List<Information> getInformations(String urlAddress, String page, String sort );

    List<String> getNameCategory();
}
