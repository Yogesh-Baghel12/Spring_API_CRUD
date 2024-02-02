package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
	List<Student> findall();

	Student findById(int theid);
	Student save(Student theStudent);
	Student deleteById(int theid);

}
