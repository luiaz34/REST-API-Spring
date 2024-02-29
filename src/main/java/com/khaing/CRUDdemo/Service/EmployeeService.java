package com.khaing.CRUDdemo.Service;

import java.util.List;

import com.khaing.CRUDdemo.DAO.EmployeeDAO;
import com.khaing.CRUDdemo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
}
