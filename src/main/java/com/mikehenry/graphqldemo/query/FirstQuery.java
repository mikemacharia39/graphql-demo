package com.mikehenry.graphqldemo.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class FirstQuery implements GraphQLQueryResolver {

    public String sampleString() {
        return "First Query";
    }
}
