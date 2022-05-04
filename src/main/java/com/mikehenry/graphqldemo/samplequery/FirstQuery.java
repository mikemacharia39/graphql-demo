package com.mikehenry.graphqldemo.samplequery;

import com.mikehenry.graphqldemo.request.StudentName;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class FirstQuery implements GraphQLQueryResolver {

    public String sampleString() {
        return "First Query";
    }

    public String anotherSampleString() {
        return "Another Query";
    }

    public String withTwoParamsString(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public String getName(StudentName studentName) {
        return studentName.getFirstName() + " " + studentName.getLastName();
    }
}
