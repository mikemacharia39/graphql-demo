package com.mikehenry.graphqldemo.request;

import com.mikehenry.graphqldemo.filter.CourseNameFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrolCourseRequest {

    private CourseNameFilter course;
}
