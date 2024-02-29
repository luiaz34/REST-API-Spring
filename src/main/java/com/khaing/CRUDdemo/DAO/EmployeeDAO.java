package com.khaing.CRUDdemo.DAO;

import java.util.List;

import com.khaing.CRUDdemo.entity.Employee;

public interface EmployeeDAO {
    List <Employee> findAll();
    
}