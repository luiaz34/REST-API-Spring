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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("creating the new student object...");
		Student new1 = new Student("khaing", "myal", "khaing@gmail.com");
		studentDAO.save(new1);
		System.out.println(new1.getId());
	}
}
