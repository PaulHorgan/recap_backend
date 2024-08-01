package com.example.demo.services;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.Employee;
import com.example.demo.repos.EmployeeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<EmployeeDto> getAll() {
        List<EmployeeDto> dtos = new ArrayList<>();
        List<Employee> found = this.repo.findAll();
        for (Employee employee : found) {
            dtos.add(new EmployeeDto(employee));
        }

        return dtos;
    }

    public ResponseEntity<?> getEmployee(Integer id) {
        Optional<Employee> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No employee found with id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new EmployeeDto(found.get()));
    }

    public ResponseEntity<EmployeeDto> createEmployee(Employee newEmployee) {
        Employee created = this.repo.save(newEmployee);

        return new ResponseEntity<>(new EmployeeDto(created), HttpStatus.CREATED);
    }

    public ResponseEntity<?> removeEmployee(Integer id) {
        Optional<Employee> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No employee found with id " + id, HttpStatus.NOT_FOUND);
        }
        this.repo.deleteById(id);
        return ResponseEntity.ok("Employee with id " + id + " has been deleted.");
    }

    public ResponseEntity<?> updateEmployee(Integer id,
                                            String firstName,
                                            String surname){

        Optional<Employee> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No Employee found with ID " + id, HttpStatus.NOT_FOUND);
        }

        Employee toUpdate = found.get();

        if (firstName != null) toUpdate.setFirstName(firstName);
        if (surname != null) toUpdate.setSurname(surname);
        Employee updated = this.repo.save(toUpdate);
        return ResponseEntity.ok(new EmployeeDto(updated));


    }



}