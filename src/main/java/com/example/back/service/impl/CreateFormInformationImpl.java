package com.example.back.service.impl;

import com.example.back.model.dto_data.Info;
import com.example.back.model.request_data.Articles;
import com.example.back.model.request_data.News;
import com.example.back.repository.InfoRepository;
import com.example.back.service.CreateFormInformation;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;

@Service
public class CreateFormInformationImpl implements CreateFormInformation {

    private final InfoRepository infoRepository;

    public CreateFormInformationImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public void listInformation(News news, String category ) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth(),
                0,
                0,
                0,
                0,
                now.getZone());
        if( !(infoRepository.findInfoByCategoryAndDate( category, zonedDateTime ).size() > 0) ) {
            List<Articles> articles = Arrays.asList(news.getArticles());
            for (Articles articles1 : articles) {
                infoRepository.save(new Info(
                        articles1.getId(),
                        articles1.getAuthor(),
                        articles1.getPublishedAt(),
                        articles1.getTitle(),
                        articles1.getDescription(),
                        category
                ));
            }
        }
    }
}
