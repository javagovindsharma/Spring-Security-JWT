package com.xadmin.SpringSecurityJWT.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xadmin.SpringSecurityJWT.entity.Course;
import com.xadmin.SpringSecurityJWT.entity.Student;
import com.xadmin.SpringSecurityJWT.repository.StudentRepository;



@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public void allocateStudentToCourse(Long studentId, Set<Course> course) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        optionalStudent.ifPresent(student -> {
           student.setLikedCourses(course);
        });
        studentRepository.save(optionalStudent.get());
    }

    public void updateStudentCourses(Long studentId, Set<Course> updatedCourses) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        optionalStudent.ifPresent(student -> {
        	  student.setLikedCourses(updatedCourses);
        });
        studentRepository.save(optionalStudent.get());
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
