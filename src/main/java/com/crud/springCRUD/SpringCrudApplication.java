package com.crud.springCRUD;

import com.crud.springCRUD.DAO.StudentDAO;
import com.crud.springCRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			// createMultipleStudent(studentDAO);
			viewStudent(studentDAO);
		};
	}

	private void viewStudent(StudentDAO studentDAO) {
		int id1= 1;
		Student view1 = studentDAO.findById(id1);
		System.out.println(view1);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// Create multiple student 
		Student new1 = new Student("tom", "holland", "tombholland@gmail.com");
		Student new2 = new Student("jack", "hollow", "jackhollow@gmail.com");
		Student new3 = new Student("mary", "james", "maryjames@gmail.com");
		Student new4 = new Student("peter", "parker", "peterparker@gmail.com");
		// save the object
		studentDAO.save(new1);
		studentDAO.save(new2);
		studentDAO.save(new3);
		studentDAO.save(new4);
	}

}
