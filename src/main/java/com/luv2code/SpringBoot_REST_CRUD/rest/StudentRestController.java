package com.luv2code.SpringBoot_REST_CRUD.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringBoot_REST_CRUD.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
    @RequestMapping("/api")
public class StudentRestController {
    
    List<Student> theStudents;
    
    // Define @PostConstructor to load the student data.

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        
        theStudents.add(new Student("Meet", "Shah"));
        theStudents.add(new Student("Kunj", "Shah"));
        theStudents.add(new Student("Prexu", "Shah"));
        theStudents.add(new Student("Shreya", "Shah"));
        theStudents.add(new Student("Rajesh", "Shah"));
    }

    // Define the endpoint for "/students" return the list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        
        // For now, not connecting any external database, can add here later.  
        // For now, manually adding data to the student list and return them.

        return theStudents;
    }

    //define endpoints for "/student/{studentID}"

    @GetMapping("/students/{studentID}")
    public Student getStudentByID(@PathVariable int studentID){
        
        //Just index of the list...for learning, later I will add studentID parameter from database...
        return theStudents.get(studentID);
    }
}