package com.example.back.model.dto_data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author")
    private String author;
    @Column(name = "date")
    private ZonedDateTime date;
    @Column(name = "info")
    private String info;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @Column(name = "category")
    private String category;


}
