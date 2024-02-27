package com.crud.springCRUD.DAO;

import com.crud.springCRUD.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id1);

}
