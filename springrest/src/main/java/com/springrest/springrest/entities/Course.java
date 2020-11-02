package com.springrest.springrest.entities;


import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.util.concurrent.TimeUnit;

@Measurement(name = "Course")
public class Course {

    @Column(name = "courseID")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    public Course(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
