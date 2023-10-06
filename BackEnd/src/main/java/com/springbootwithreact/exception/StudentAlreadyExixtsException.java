package com.springbootwithreact.exception;

public class StudentAlreadyExixtsException extends RuntimeException {
    public StudentAlreadyExixtsException(String s) {
        super(s);
    }
}
