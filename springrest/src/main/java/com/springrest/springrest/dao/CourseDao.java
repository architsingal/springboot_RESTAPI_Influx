package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseDao{


    public List<Course> getCourses();
    public Course getCourse(long courseID);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(String title);
}
