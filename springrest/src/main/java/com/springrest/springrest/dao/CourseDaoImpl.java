package com.springrest.springrest.dao;


import com.springrest.springrest.entities.Course;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.stereotype.Repository;
import org.influxdb.dto.Point;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class CourseDaoImpl implements CourseDao{

    //connection with influxdb
    final InfluxDB connection = InfluxDBFactory.connect("http://localhost:8086");
    String dbName = "CoursesDB";


        Query queryObject = new Query("CREATE DATABASE "+dbName,dbName);
        QueryResult queryResult= connection.query(queryObject);

        String retentionPolicyName = "one_day_only";
        Query queryObject1 = new Query("CREATE RETENTION POLICY "+ retentionPolicyName + " ON " + dbName + " DURATION 1d REPLICATION 1 DEFAULT",dbName);
        QueryResult queryResult1 = connection.query(queryObject1);


    private List<Course> getPoints(String query)
    {
        Query queryObject = new Query(query,dbName);
        QueryResult queryResult = connection.query(queryObject);

        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        return resultMapper.toPOJO(queryResult,Course.class);
    }



    @Override
    public List<Course> getCourses() {
        List<Course> allCourses = getPoints("Select * from Course");
        return allCourses;
    }

    @Override
    public Course getCourse(long courseID) {
        List<Course> coursePointList = getPoints("Select * from Course where courseID="+courseID);
        if(coursePointList.size()==0){
            return null;
        }
        else {
            return coursePointList.get(0);
        }

    }

    @Override
    public Course addCourse(Course course) {


        Point point = Point.measurement("Course")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("courseID",course.getId())
                .tag("title",course.getTitle())
                .addField("description",course.getDescription())
                .build();
        connection.write(dbName,"one_day_only",point);
        return course;


    }

    @Override
    public Course updateCourse(Course course) {
        return null;

    }

    @Override
    public void deleteCourse(String title) {
        String query = "DELETE FROM Course where title="+"'"+title+"'";
        Query queryObject = new Query(query, dbName);
        QueryResult queryResult = connection.query(queryObject);

    }


}
