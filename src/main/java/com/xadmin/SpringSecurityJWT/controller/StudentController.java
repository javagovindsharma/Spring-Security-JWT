package com.xadmin.SpringSecurityJWT.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringSecurityJWT.entity.Course;
import com.xadmin.SpringSecurityJWT.entity.Student;
import com.xadmin.SpringSecurityJWT.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
    private StudentService studentService;

   

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PostMapping("/{studentId}/allocate")
    public void allocateStudentToCourse(@PathVariable Long studentId, @RequestBody Set<Course> course) {
        studentService.allocateStudentToCourse(studentId, course);
    }

    @PutMapping("/{studentId}/courses")
    public void updateStudentCourses(@PathVariable Long studentId, @RequestBody Set<Course> updatedCourses) {
        studentService.updateStudentCourses(studentId, updatedCourses);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
