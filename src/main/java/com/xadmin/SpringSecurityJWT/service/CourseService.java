package com.xadmin.SpringSecurityJWT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringSecurityJWT.entity.Course;
import com.xadmin.SpringSecurityJWT.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private  CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void updateCourse(Long courseId, Course updatedCourse) {
        if (courseRepository.existsById(courseId)) {
            updatedCourse.setId(courseId);
            courseRepository.save(updatedCourse);
        }
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
