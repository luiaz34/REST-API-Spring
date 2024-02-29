package com.khaing.CRUDdemo.Rest;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.khaing.CRUDdemo.DAO.EmployeeDAO;
import com.khaing.CRUDdemo.Service.EmployeeService;
import com.khaing.CRUDdemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRest {
    private EmployeeService employeeService;

    public EmployeeRest(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

    @GetMapping(value = { "/employees", "/employees/" })
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee==null){
            throw new RuntimeException("id not found....");
        }
        return employee;
      
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deletEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee==null){
            throw new RuntimeException("not found");
        }
        else {
            employeeService.deleteById(id);
            return "deleted!";

        }
        
    }
}
