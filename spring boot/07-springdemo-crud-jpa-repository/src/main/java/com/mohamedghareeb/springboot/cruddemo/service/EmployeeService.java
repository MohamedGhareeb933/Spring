package com.mohamedghareeb.springboot.cruddemo.service;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> employeeList();

    public Employee getEmployee(int empId);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int empId);
}
