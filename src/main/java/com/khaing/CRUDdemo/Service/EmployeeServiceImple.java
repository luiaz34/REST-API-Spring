package com.khaing.CRUDdemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaing.CRUDdemo.DAO.EmployeeDAO;
import com.khaing.CRUDdemo.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImple(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }
    
}
