package com.example.back.model.request_data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Articles {

    private int id;
    private String author;
    private String title;
    private String url;
    private String urlToImage;
    private ZonedDateTime publishedAt;
    private String description;


}
