package com.springbootwithreact;

import com.springbootwithreact.model.Student;
import com.springbootwithreact.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    IStudentRepository iStudentRepository;
    @Override
    public void run(String... args) throws Exception {

        String firstName = "Shail";
        String lastName = "Khan";
        List<Student> byFirstNameOrLastNameByJPQL = iStudentRepository.findByFirstNameOrLastNameByJPQL(firstName, lastName);
        byFirstNameOrLastNameByJPQL.forEach(System.out::println);
    }
}
