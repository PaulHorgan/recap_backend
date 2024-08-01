package com.example.demo.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.*;
import com.example.demo.services.EmployeeService;
import com.example.demo.entities.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="employee")
public class EmployeeController {

    private final EmployeeService service;
    
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping("employee/getAll")
    public List <EmployeeDto> getAllEmployees(){ return service.getAll();}

    @GetMapping("employee/get/{id}")
    public ResponseEntity<?> getEmployeeById (@PathVariable Integer id) {
        return service.getEmployee(id);
    }

    @PostMapping("employee/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody Employee newEmployee){
        return service.createEmployee(newEmployee);
    }

    @DeleteMapping("employee/remove/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable Integer id) {
        return service.removeEmployee(id);
    }

}


