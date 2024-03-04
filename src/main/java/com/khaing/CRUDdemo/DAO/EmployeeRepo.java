package com.khaing.CRUDdemo.DAO;

import com.khaing.CRUDdemo.entity.Employee; // Import the Employee entity class
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    // Specify the domain type as Employee and the ID type as Long
}
