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
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

}
