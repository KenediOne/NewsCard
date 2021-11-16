package com.example.back.model.dto_data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Information {

    private int id;
    private String author;
    private ZonedDateTime date;
    private String info;
    private String description;


}
