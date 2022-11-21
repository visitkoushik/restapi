package com.home.resapi.restapi.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.home.resapi.restapi.domain.Employee;

 

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

   
}
