package com.springrest.springbootapi.services;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springbootapi.entities.Course;
import com.springrest.springbootapi.dao.CourseDao;

@Service
public class CourseServiceImplement implements CourseService {
    @Autowired
    private CourseDao courseDao;

    // private List<Course> list;

    public CourseServiceImplement() {
        // list = new ArrayList<>();
        // list.add(new Course(145, "Java Core Course", "This course contains basics of java"));
        // list.add(new Course(4343, "Spring Boot Course", "Creating rest api using spring boot"));
    }

    // Retrieve a course by its ID from the database using Spring Data JPA
    @Override
    public Course getCourse(long courseID) {
        // Course c = null;
        // for (Course course : list) {
        //     if (course.getId() == courseID) {
        //         c = course;
        //         break;
        //     }
        // }
        return courseDao.findById(courseID).get();
    }

    // Add a course to the database using Spring Data JPA
    @Override
    public Course addCourse(Course course) {
        // list.add(course);
        courseDao.save(course);
        return course;
    }

    // Update a course in the database using Spring Data JPA
    @Override
    public Course updateCourse(Course course) {
        // list.forEach(e -> {
        //     if (e.getId() == course.getId()) {
        //         e.setTitle(course.getTitle());
        //         e.setDescription(course.getDescription());
        //     }
        // });
        courseDao.save(course);
        return course;
    }

    // Delete a course from the database using Spring Data JPA
    @Override
    public Course deleteCourse(long parseLong) {
        // Course c = null;
        // for (Course course : list) {
        //     if (course.getId() == parseLong) {
        //         c = course;
        //         list.remove(course);
        //         break;
        //     }
        Course entity = courseDao.findById(parseLong).get();
        courseDao.delete(entity);
        return entity;
        
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }
    
}
