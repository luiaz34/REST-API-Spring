package com.khaing.CRUDdemo.Rest;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khaing.CRUDdemo.DAO.EmployeeRepo;
import com.khaing.CRUDdemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRest {
    private EmployeeRepo employeeRepo;

    public EmployeeRest(EmployeeRepo theEmployeeService){
        this.employeeRepo = theEmployeeService;
    }

    @GetMapping(value = { "/employees", "/employees/" })
    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional findById(@PathVariable int employeeId){
        Optional employee = employeeRepo.findById(employeeId);
        if (employee==null){
            throw new RuntimeException("id not found....");
        }
        return employee;
      
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeRepo.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deletEmployee(@PathVariable int id){
        Optional employee = employeeRepo.findById(id);
        if (employee==null){
            throw new RuntimeException("not found");
        }
        else {
            employeeRepo.deleteById(id);
            return "deleted!";

        }
        
    }
}
