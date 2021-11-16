package com.example.back.service.impl;

import com.example.back.client.ConstructorQuerys;
import com.example.back.client.RestTemplate;
import com.example.back.client.impl.RestTemplateImpl;
import com.example.back.model.dto_data.Information;
import com.example.back.service.CreateFormInformation;
import com.example.back.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Value("${spring.dataOfSite}")
    private String dataOfSite;

    private final CreateFormInformation createFormInformation;
    private final ConstructorQuerys constructorQuerys;


    @Autowired
    public NewsServiceImpl(CreateFormInformation createFormInformation, ConstructorQuerys constructorQuerys) {
        this.createFormInformation = createFormInformation;
        this.constructorQuerys = constructorQuerys;
    }


    @Override
    public List<Information> getInformations(String urlAddress, String page, String sort ) {
        return createFormInformation.listInformation( getRestTemplate( constructorQuerys.getDataForQuery( urlAddress ) ).getUserByIdSync(), page, sort );
    }

    @Override
    public List<String> getNameCategory() {
        String[] next = dataOfSite.split(" ");
        List<String> listOfCategory = new ArrayList<>();
        Arrays.stream(next).forEach( category -> listOfCategory.add( category ) );
        return listOfCategory;
    }

    private RestTemplate getRestTemplate( String urlAddress ){
        return new RestTemplateImpl( urlAddress );
    }
}
