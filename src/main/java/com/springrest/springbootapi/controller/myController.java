package com.springrest.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springbootapi.entities.Course;
import com.springrest.springbootapi.services.CourseService;

@RestController
public class myController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to the courses app";
    }
    // get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }
    // get single course
    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return this.courseService.getCourse(Long.parseLong(courseID));
    }
    // add course
    @PostMapping("/courses")
     public ResponseEntity<Course>  addCourse(@RequestBody Course course){
         return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    // update course using PUT
    @PutMapping("/courses")
     public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }
    // delete course 
    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
    

