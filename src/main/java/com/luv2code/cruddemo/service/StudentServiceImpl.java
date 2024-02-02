package com.luv2code.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
     
    private StudentDAO studentDAO;
    public StudentServiceImpl(StudentDAO theStudentDAO){
        studentDAO = theStudentDAO; 
    }

    @Override
    public List<Student> findall(){
        return  studentDAO.findall();  

    }
     
    @Transactional
    @Override
    public Student findById(int theid) {
        return  studentDAO.findById(theid);
    }
     
    @Transactional
    @Override
    public Student save(Student theStudent) {
       return   studentDAO.save(theStudent);
    }
    
    @Transactional
    @Override
    public void deleteById(int theid) {
        
        studentDAO.deleteById(theid);
    }
}
