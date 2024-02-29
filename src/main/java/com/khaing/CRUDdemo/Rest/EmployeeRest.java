package com.khaing.CRUDdemo.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khaing.CRUDdemo.DAO.EmployeeDAO;
import com.khaing.CRUDdemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRest {
    private EmployeeDAO employeeDAO;

    public EmployeeRest(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
