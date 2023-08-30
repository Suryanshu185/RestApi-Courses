package com.springrest.springbootapi.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.springrest.springbootapi.entities.Course;

@Service
public class CourseServiceImplement implements CourseService {

    private List<Course> list;

    public CourseServiceImplement() {
        list = new ArrayList<>();
        list.add(new Course(145, "Java Core Course", "This course contains basics of java"));
        list.add(new Course(4343, "Spring Boot Course", "Creating rest api using spring boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseID) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseID) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public Course deleteCourse(long parseLong) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == parseLong) {
                c = course;
                list.remove(course);
                break;
            }
        }
        return c;
    }
    
}
