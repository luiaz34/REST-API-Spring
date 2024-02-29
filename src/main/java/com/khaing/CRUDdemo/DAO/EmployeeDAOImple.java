package com.khaing.CRUDdemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khaing.CRUDdemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImple implements EmployeeDAO{
    private EntityManager em;

    @Autowired
    public EmployeeDAOImple(EntityManager entityManager){
        this.em = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("From Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = em.find(Employee.class, id);
        return employee;
        // retunr the employee
    }

    @Override
    public Employee save(Employee thEmployee) {
        // save the employee
        Employee employee = em.merge(thEmployee);
        // return the employee
        return employee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee by id
        Employee employee = em.find(Employee.class, id);
        // delete the employee 
        em.remove(employee);
    
    

}
}
