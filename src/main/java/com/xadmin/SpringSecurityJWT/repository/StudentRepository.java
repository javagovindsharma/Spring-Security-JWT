package com.xadmin.SpringSecurityJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xadmin.SpringSecurityJWT.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
