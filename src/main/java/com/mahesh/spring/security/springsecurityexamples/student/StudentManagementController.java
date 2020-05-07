package com.mahesh.spring.security.springsecurityexamples.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James Bond"),
            new Student(2,"Maria Jones")

    );
    @GetMapping
    public List<Student> getAllStudents(){
        System.out.println("Get Invoked");
        return STUDENTS;
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("Post Invoked");
        System.out.println(student);
    }
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println("Delete Invoked");
        System.out.println(studentId);
    }
    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable Integer studentId ,@RequestBody Student student){
        System.out.println("Put Invoked");
        System.out.println(String.format("%s %s",studentId,student));
    }


}
