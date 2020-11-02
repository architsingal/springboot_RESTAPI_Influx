package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/home")
    public String home()
    {
        return "Welcome to archit application";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getCourses();
    }

    //
    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID)
    {
        return this.courseService.getCourse(Long.parseLong(courseID));
    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{title}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String title)
    {
        try {
            this.courseService.deleteCourse(title);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch ( Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
