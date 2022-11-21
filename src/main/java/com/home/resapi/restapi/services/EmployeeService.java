package com.home.resapi.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.home.resapi.restapi.domain.Employee;

public interface EmployeeService { 
    List<Employee> findAll();
    Employee findById(Long Id);
    Employee save(Employee employee);
    List<Employee> findByFirstName(String firstname);
    Employee update(Employee employee,Long id);
}
