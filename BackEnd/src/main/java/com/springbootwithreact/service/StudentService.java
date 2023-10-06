package com.springbootwithreact.service;

import com.springbootwithreact.exception.StudentAlreadyExixtsException;
import com.springbootwithreact.exception.StudentNotFoundException;
import com.springbootwithreact.model.Student;
import com.springbootwithreact.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // this only works for final fields
public class StudentService implements IStudentService{
    private final IStudentRepository iStudentRepository;

    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExits(student.getEmail())){
            throw new StudentAlreadyExixtsException("Already Exits this eamil : " + student.getEmail());
        }
        return iStudentRepository.save(student);
    }



    @Override
    public List<Student> getStudents() {return iStudentRepository.findAll();}

    @Override
    public Student updateStudent(Student student , Long id) {
        return iStudentRepository.findById(id).map(st ->{
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return iStudentRepository.save(st);
        }).orElseThrow(()-> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return iStudentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Sorry, this student could not be found with this id : " + id));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!iStudentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, this student could not be found");
        }
        iStudentRepository.deleteById(id);
    }

    private boolean studentAlreadyExits(String email) {
        return iStudentRepository.findByEmail(email).isPresent();
    }
}
