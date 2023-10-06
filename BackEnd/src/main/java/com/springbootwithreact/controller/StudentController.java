package com.springbootwithreact.controller;

import com.springbootwithreact.model.Student;
import com.springbootwithreact.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor // this only works for final fields
public class StudentController {

    private final IStudentService iStudentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.FOUND);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return iStudentService.addStudent(student);
    }

    @PutMapping(path = "/update/{id}")
    public Student updateStudent(@RequestBody Student student , @PathVariable Long id){
        return iStudentService.updateStudent(student,id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        iStudentService.deleteStudent(id);
    }
    @GetMapping(path = "/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return iStudentService.getStudentById(id);
    }

}
