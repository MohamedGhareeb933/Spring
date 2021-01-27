package com.mohamedghareeb.springboot.cruddemo.dao;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> employeeList() {
        return entityManager.createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public Employee getEmployee(int empId) {
        return entityManager.find(Employee.class, empId);
    }

    @Override
    public void saveEmployee(Employee employee) {
       Employee dbEmployee = entityManager.merge(employee);

       // set the employee id with id generated in database.
       employee.setId(dbEmployee.getId());
    }


    @Override
    public void deleteEmployee(int empId) {
        entityManager.createQuery("delete from Employee where id=:empid")
                .setParameter("empid", empId)
                .executeUpdate();
    }


}
