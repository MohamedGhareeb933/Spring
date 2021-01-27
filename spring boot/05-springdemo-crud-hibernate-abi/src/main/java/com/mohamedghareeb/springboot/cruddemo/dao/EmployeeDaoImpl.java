package com.mohamedghareeb.springboot.cruddemo.dao;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int empId) {
        Session session = entityManager.unwrap(Session.class);

       return session.get(Employee.class, empId);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }


    @Override
    public void deleteEmployee(int empId) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee where id=:idparam")
                .setParameter("idparam", empId);

        query.executeUpdate();
    }


}
