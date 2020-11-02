package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    //telling spring to create object for us
    @Autowired
    private CourseDao courseDao ;



    // temporarily creating list to return something
//    List<Course>list;

    public CourseServiceImpl() {

//        list = new ArrayList<>();
//        list.add(new Course(145,"Java Core Course","This course contains basics of Java"));
//        list.add(new Course(4343, "Spring boot course", "creating rest api using spring boot"));
    }

    @Override
    public List<Course> getCourses() {

        return this.courseDao.getCourses();

        //return courseDao.findAll();



        //return list;
    }

    @Override
    public Course getCourse(long courseID) {

        return this.courseDao.getCourse(courseID);
        //return courseDao.getOne(courseID);
//        Course c = null;
//        for(Course course:list)
//        {
//            if(course.getId()==courseID)
//            {
//                c=course;
//                break;
//            }
//        }
        //return c;
    }

    @Override
    public Course addCourse(Course course) {

        return this.courseDao.addCourse(course);
        //return courseDao.save(course);
//        list.add(course);
        //return course;


    }

    @Override
    public Course updateCourse(Course course) {

        return this.courseDao.updateCourse(course);

        //return courseDao.save(course);
//        list.forEach(e->{
//            if(e.getId()==course.getId())
//            {
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        //return course;

    }

    @Override
    public void deleteCourse(String title) {


        this.courseDao.deleteCourse(title);
        //Course c= courseDao.getOne(courseID);
        //courseDao.delete(c);



//        list=this.list.stream().filter(e->e.getId()!=courseID).collect(Collectors.toList());
        }


    }
