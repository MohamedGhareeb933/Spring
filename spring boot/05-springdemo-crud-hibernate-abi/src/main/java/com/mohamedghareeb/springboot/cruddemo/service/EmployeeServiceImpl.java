package com.mohamedghareeb.springboot.cruddemo.service;

import com.mohamedghareeb.springboot.cruddemo.dao.EmployeeDao;
import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional // handle Transaction management . we dont have to manually start and commit the transaction
    public List<Employee> employeeList() {
        return employeeDao.employeeList();
    }

    @Override
    @Transactional
    public Employee getEmployee(int empId) {
        return employeeDao.getEmployee(empId);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int empId) {
        employeeDao.deleteEmployee(empId);
    }
}
