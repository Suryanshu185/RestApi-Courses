package com.springrest.springbootapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Course {

    @Id
    private long id;
    private String title;
    private String description;

    public Course(long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Course() {
        super();
    }
    // generate getters and setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String toString(){
        return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
    }

}
