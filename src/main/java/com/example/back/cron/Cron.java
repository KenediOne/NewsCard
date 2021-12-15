package com.example.back.cron;

import com.example.back.service.NewsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Cron {

    private final NewsService newsService;

    public Cron(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(cron = "0 0\30 * * * ?")
    public void cronNews() {
        newsService.createNews();
    }

}
