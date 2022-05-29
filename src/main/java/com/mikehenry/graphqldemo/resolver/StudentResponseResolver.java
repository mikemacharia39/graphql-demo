package com.mikehenry.graphqldemo.resolver;

import com.mikehenry.graphqldemo.response.StudentResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

}
