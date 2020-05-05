package com.mahesh.spring.security.springsecurityexamples.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James Bond"),
            new Student(2,"Maria Jones")

    );

    @GetMapping("/{studentID}")
    public Student getStudent(@PathVariable("studentID") Integer studentID){

        return STUDENTS.stream()
                .filter(student->studentID.equals(student.getStudentID()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student" + studentID + "does not exist"));
    }
}
