package com.mohamedghareeb.springboot.cruddemo.jpa;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeJpa extends JpaRepository<Employee, Integer> {

}
