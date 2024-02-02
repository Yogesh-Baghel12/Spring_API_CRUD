package com.luv2code.cruddemo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class StudentDAOImpl implements StudentDAO{
     
	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager){
		entityManager = theEntityManager;
	}

	@Override
	public List<Student> findall() {
		TypedQuery<Student> theQuery=entityManager.createQuery("from Student",Student.class);
		List<Student> students=theQuery.getResultList();
		
		return students;
	}

	@Override
	public Student findById(int theid) {

		Student theStudent=entityManager.find(Student.class,theid);
		
		return theStudent;
	}

	@Override
	//add student
	public Student save(Student theStudent) {
        Student dbStudent=entityManager.merge(theStudent);

		return dbStudent;
	}

	@Override
	public Student deleteById(int theid) {
		Student theStudent=entityManager.find(Student.class,theid);
		entityManager.remove(theStudent);
		return theStudent;
		
	}
	

}
