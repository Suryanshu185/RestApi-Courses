package com.springrest.springbootapi.dao;
import com.springrest.springbootapi.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
    
}
