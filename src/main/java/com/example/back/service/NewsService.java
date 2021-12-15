package com.example.back.service;

import com.example.back.model.dto_data.Info;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {

    Page<Info> getInformations(String urlAddress, Pageable pageable);

    List<String> getNameCategory();

    void createNews();
}
