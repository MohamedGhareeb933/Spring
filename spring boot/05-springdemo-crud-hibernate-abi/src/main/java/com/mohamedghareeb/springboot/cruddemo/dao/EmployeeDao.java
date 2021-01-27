package com.mohamedghareeb.springboot.cruddemo.dao;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> employeeList();

    public Employee getEmployee(int empId);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int empId);
}
