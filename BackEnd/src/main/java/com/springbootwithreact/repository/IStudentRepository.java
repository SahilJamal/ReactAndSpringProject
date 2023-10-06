package com.springbootwithreact.repository;

import com.springbootwithreact.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student , Long> {
    Optional<Student> findByEmail(String email);

    @Query(value = "SELECT s FROM Student s where s.firstName =?1 or s.lastName =?2")
    List<Student> findByFirstNameOrLastNameByJPQL(String firstName, String lastName);
}
