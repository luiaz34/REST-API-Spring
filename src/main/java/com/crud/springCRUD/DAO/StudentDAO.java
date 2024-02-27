package com.crud.springCRUD.DAO;

import java.util.List;

import com.crud.springCRUD.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id1);
    List<Student> findAll();
    List<Student> findByLastName(String lastname);

}
