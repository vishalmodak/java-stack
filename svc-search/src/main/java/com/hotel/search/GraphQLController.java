package com.hotel.search;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.search.graphql.HotelDetailsFetcher;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.annotations.GraphQLAnnotations;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

@RestController
public class GraphQLController {
    
    private static final Logger LOG = LoggerFactory.getLogger(GraphQLController.class);

    @Autowired
    private GraphQL detailsGraphQL;
    
    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public Object graphql(@RequestBody SearchCriteria input) throws Exception {
        ExecutionResult executionResult = detailsGraphQL.execute(input.query, input.variables);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
            LOG.error("Errors: {}", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }
    
    @Bean
    public GraphQL detailsGraphQL() throws Exception {
        GraphQLObjectType graphQLObjectType = GraphQLAnnotations.object(HotelDetailsFetcher.class);
        GraphQLSchema graphQLSchema = GraphQLSchema.newSchema().query(graphQLObjectType).build();
        return GraphQL.newGraphQL(graphQLSchema).build();
    }
}
