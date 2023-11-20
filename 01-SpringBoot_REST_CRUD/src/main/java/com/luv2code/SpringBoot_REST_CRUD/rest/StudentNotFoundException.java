package com.luv2code.SpringBoot_REST_CRUD.rest;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause){
        super(cause);
    }
}
