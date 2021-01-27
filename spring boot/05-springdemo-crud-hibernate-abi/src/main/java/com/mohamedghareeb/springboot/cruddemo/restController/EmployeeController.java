package com.mohamedghareeb.springboot.cruddemo.restController;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import com.mohamedghareeb.springboot.cruddemo.exception.EmployeeExceptionThrower;
import com.mohamedghareeb.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployeeList() {
        return employeeService.employeeList();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable int empId) {
        Employee employee = employeeService.getEmployee(empId);

        if (employee == null) {
            throw new EmployeeExceptionThrower("employee with id: " + empId + " is not found");
        }

        return employee;
    }

    @PostMapping("/employee")
    public Employee saveEmpoyee(@RequestBody Employee employee) {

        employee.setId(0);

        employeeService.saveEmployee(employee);

        return employee;
    }


    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employee/{empId}")
    public String deleteEmployee(@PathVariable int empId){

        Employee employee = employeeService.getEmployee(empId);

        if (employee == null) {
            throw new EmployeeExceptionThrower("employee with id: " + empId + " is not found");
        }

        employeeService.deleteEmployee(empId);

        return "Employee Deleted: " + empId;
    }
}
