package com.springrest.springbootapi.services;

import java.util.List;
import com.springrest.springbootapi.entities.Course;

public interface CourseService {

    List<Course> getCourses();

    Course getCourse(long courseID);

    Course addCourse(Course course); 

    Course updateCourse(Course course);

    Course deleteCourse(long parseLong);
}
