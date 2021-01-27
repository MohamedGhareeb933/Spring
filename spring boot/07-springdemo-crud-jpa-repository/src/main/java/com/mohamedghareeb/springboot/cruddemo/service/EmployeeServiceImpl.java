package com.mohamedghareeb.springboot.cruddemo.service;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import com.mohamedghareeb.springboot.cruddemo.exception.EmployeeExceptionThrower;
import com.mohamedghareeb.springboot.cruddemo.jpa.EmployeeJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeJpa employeeJpa;

    @Override
    public List<Employee> employeeList() {
        return employeeJpa.findAll();
    }

    @Override
    public Employee getEmployee(int empId)
    {
        Optional<Employee> employee = employeeJpa.findById(empId);

        if (employee.isEmpty()) {
            throw new EmployeeExceptionThrower("employee with id: " + empId + " is not found");
        }

        return employee.get();
    }

    @Override
    public void saveEmployee(Employee employee) { employeeJpa.save(employee); }

    @Override
    public void deleteEmployee(int empId) {
        employeeJpa.deleteById(empId);
    }
}
