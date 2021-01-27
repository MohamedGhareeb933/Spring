package com.mohamedghareeb.springboot.cruddemo.jpa;

import com.mohamedghareeb.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeJpa extends JpaRepository<Employee, Integer> {

}
