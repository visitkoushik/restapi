package com.home.resapi.restapi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.home.resapi.restapi.domain.Employee;
import com.home.resapi.restapi.exceptions.ResourceNotFoundException;
import com.home.resapi.restapi.repositories.EmployeeRepository;
import com.home.resapi.restapi.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {



    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
    
        return this.employeeRepository.save(employee);
        
    }

    @Override
    public List<Employee> findAll() {
        
        return   this.employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByFirstName(String firstname) {
       List<Employee> employees = this.employeeRepository.findAll();
       ArrayList<Employee> filteredEmployee = new ArrayList<>(); 
       employees.forEach(e->{
            if(e.getFirstName().equals(firstname))
            {
                filteredEmployee.add(e);
            }
       });
        return  filteredEmployee ;
    }

    @Override
    public Employee findById(Long Id) {
      return  this.employeeRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Emaployee", "ID", Id));
       
    }

    @Override
    public Employee update(Employee employee,Long id) {
        
        Employee exisitingWEmployee = this.employeeRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Employee", "ID", employee.getId()));

           exisitingWEmployee.setFirstName(employee.getFirstName()); 
           exisitingWEmployee.setLastName(employee.getLastName()); 
           exisitingWEmployee.setEmail(employee.getEmail()); 
        return this.employeeRepository.save(exisitingWEmployee);
    }

    
}
