package com.crud.springCRUD.DAO;

import com.crud.springCRUD.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOimplement implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOimplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by first_name",Student.class);
        return theQuery.getResultList();
        
    }

    @Override
    public List<Student> findByLastName(String lastname) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE last_name=:lastname ",Student.class);
        // set the parameters
        theQuery.setParameter("lastname", lastname);
        // return the results
        return theQuery.getResultList();
    }

    
}
