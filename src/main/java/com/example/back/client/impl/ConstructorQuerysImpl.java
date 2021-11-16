package com.example.back.client.impl;

import com.example.back.client.ConstructorQuerys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstructorQuerysImpl implements ConstructorQuerys {

    Logger log = LoggerFactory.getLogger( ConstructorQuerysImpl.class );

    @Value("${spring.value.https}")
    private String value;

    @Value("${spring.dataOfSite}")
    private String dataOfSite;

    @Value("${spring.apiKey}")
    private String apiKey;

    @Override
    public String getDataForQuery(String data) {
        String[] text = dataOfSite.split(" ");
        String constructorQuery = ""+value;
        if( !text[2].equals( data ) ){
            constructorQuery += "country="+data+"&apiKey="+apiKey;
        }else {
            constructorQuery += "sources="+data+"&apiKey="+apiKey;
        }
        log.info( "Link for query: " + constructorQuery );
        return constructorQuery;
    }
}
