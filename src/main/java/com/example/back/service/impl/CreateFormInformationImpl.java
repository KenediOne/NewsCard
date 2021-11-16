package com.example.back.service.impl;

import com.example.back.model.dto_data.Information;
import com.example.back.model.request_data.Articles;
import com.example.back.model.request_data.News;
import com.example.back.service.CreateFormInformation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CreateFormInformationImpl implements CreateFormInformation {

    @Override
    public List<Information> listInformation(News news, String page, String sort ) {
        List<Information> list = new ArrayList<>();
        List<Articles> articles = Arrays.asList(news.getArticles());
        for( int iteration = 1; iteration < articles.size(); iteration++ ){
            articles.get( iteration ).setId( iteration );
        }
        if( Integer.parseInt( page.split(",")[0] ) < articles.size() ){
            int maxValueOfArticles = Integer.parseInt( page.split(",")[1] ) > articles.size()? articles.size() : Integer.parseInt( page.split(",")[1] );
            articles.subList( Integer.parseInt( page.split(",")[0] ), maxValueOfArticles ).stream().forEach( articles1 -> {
                list.add(new Information(
                        articles1.getId(),
                        articles1.getAuthor(),
                        articles1.getPublishedAt(),
                        articles1.getTitle(),
                        articles1.getDescription()
                ));
            });
        }
        if ( sort.equals( "ASC" ) ){
            System.out.println("ASC");
            Collections.sort(list, new Comparator<Information>() {
                @Override
                public int compare(Information o1, Information o2) {
                    return o1.getId() > o2.getId()? -1 : 1 ;
                }
            });
        }else {
            System.out.println("DESC");
            Collections.sort(list, new Comparator<Information>() {
                @Override
                public int compare(Information o1, Information o2) {
                    return o1.getId() < o2.getId()? -1 : 1 ;
                }
            });
        }
        return list;
    }
}
