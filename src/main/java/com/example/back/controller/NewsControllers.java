package com.example.back.controller;

import com.example.back.model.dto_data.Information;
import com.example.back.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsControllers extends BaseController{

    private final NewsService newsService;

    public NewsControllers(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping(value = BaseController.INFORMATION)
    public List<Information> getInformations(
            @RequestParam(value = "category", defaultValue = "ua") String category,
            @RequestParam(value = "page", defaultValue = "0,10", required = false) String page,
            @RequestParam(value = "sort", defaultValue = "ASC", required = false) String sort
    ){
        return newsService.getInformations( category, page, sort );
    }

    @GetMapping(value = BaseController.CATEGORY)
    public List<String> getCategorys(){
        return newsService.getNameCategory();
    }
}
