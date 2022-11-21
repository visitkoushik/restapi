package com.home.resapi.restapi.controlers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.boot.model.source.spi.EmbeddedAttributeMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.resapi.restapi.domain.Employee;
import com.home.resapi.restapi.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeControler {
    



    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


        
    @PostMapping 
    public ResponseEntity<Employee>  saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(this.employeeService.save(employee), 
        HttpStatus.CREATED);
        
    }




    @GetMapping 
    public ResponseEntity<Object>  getAllEmployees(
        @RequestParam(required = false) String firstName,
        @RequestParam(name="empid",required = false) Long id
    ){

        if(firstName == null && id == null){
            return new ResponseEntity<Object> (this.employeeService.findAll(), 
            HttpStatus.OK);

        }else if(firstName!=null){
            return new ResponseEntity<Object> (this.employeeService.findByFirstName(firstName), 
                HttpStatus.OK);
        }
        else if(id!=null){
            return new ResponseEntity<Object> (this.employeeService.findById(id), HttpStatus.OK);
        }
        return null;
        
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(this.employeeService.update(employee,id), 
        HttpStatus.ACCEPTED);
    }

}
