package com.luv2code.SpringBoot_REST_CRUD.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringBoot_REST_CRUD.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    // Define the endpoint for "/students" return the list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        
        // For now, not connecting any external database, can add here later.  
        // For now, manually adding data to the student list and return them.

        List<Student> thesStudents = new ArrayList<>();
        thesStudents.add(new Student("Meet", "Shah"));
        thesStudents.add(new Student("Kunj", "Shah"));
        thesStudents.add(new Student("Prexu", "Shah"));
        thesStudents.add(new Student("Shreya", "Shah"));
        thesStudents.add(new Student("Rajesh", "Shah"));

        return thesStudents;
    }
}
