package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("create");
		String email;
		String lastName;
		String firstName;
		Student tempStudent=new Student(0,firstName="Paul", lastName="Doe",email="paul@gmail.com");
		
		System.out.println("save");
		studentDAO.save(tempStudent);
		
		System.out.println("Saved Student. Generated id:"+tempStudent.getId());
		
	}

}
