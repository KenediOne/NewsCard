package com.example.back.service.impl;

import com.example.back.client.ConstructorQuerys;
import com.example.back.client.RestTemplate;
import com.example.back.client.impl.RestTemplateImpl;
import com.example.back.model.dto_data.Info;
import com.example.back.repository.InfoRepository;
import com.example.back.service.CreateFormInformation;
import com.example.back.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final InfoRepository infoRepository;


    @Autowired
    public NewsServiceImpl(CreateFormInformation createFormInformation, ConstructorQuerys constructorQuerys, InfoRepository infoRepository) {
        this.createFormInformation = createFormInformation;
        this.constructorQuerys = constructorQuerys;
        this.infoRepository = infoRepository;
    }


    @Override
    public Page<Info> getInformations(String category, Pageable pageable) {
        return infoRepository.findInfoByCategory(category, pageable);
    }

    @Override
    public List<String> getNameCategory() {
        String[] next = dataOfSite.split(" ");
        List<String> listOfCategory = new ArrayList<>();
        Arrays.stream(next).forEach( category -> listOfCategory.add( category ) );
        return listOfCategory;
    }

    @Override
    public void createNews() {
        for(String category : getNameCategory())
        createFormInformation.listInformation( getRestTemplate( constructorQuerys.getDataForQuery( category ) ).getUserByIdSync(), category );
    }

    private RestTemplate getRestTemplate(String urlAddress ){
        return new RestTemplateImpl( urlAddress );
    }
}
