package com.hotel.search.graphql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class HotelDetailsFetcher implements DataFetcher {
    
    private static final Logger log = LoggerFactory.getLogger(HotelDetailsFetcher.class);
    

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return null;
    }

}
