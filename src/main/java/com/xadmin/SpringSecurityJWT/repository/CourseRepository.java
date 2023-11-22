package com.xadmin.SpringSecurityJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xadmin.SpringSecurityJWT.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {

}
