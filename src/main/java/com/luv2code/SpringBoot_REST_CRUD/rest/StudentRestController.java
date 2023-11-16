package com.luv2code.SpringBoot_REST_CRUD.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        //Check studentid with list size

        if ((studentID >= theStudents.size()) || studentID < 0) {
            throw new StudentNotFoundException("Student id not found:" + studentID  );
        }
        return theStudents.get(studentID);
    }

    // Add Exception Handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // Create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler... to catch general exception 
    
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(Exception exc){
        // Create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}