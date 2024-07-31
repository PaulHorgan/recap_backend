package com.example.demo.dtos;
import com.example.demo.entities.Tasks;
import com.example.demo.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDto {
    private Integer id;
    private String firstName;
    private String surname;

    private List<Tasks> tasks;

    public EmployeeDto(Employee employee){
        this.id= employee.getId();
        this.firstName = employee.getFirstName();
        this.surname = employee.getSurname();
        if(employee.getTasks() != null){
            for(Tasks task : employee.getTasks()){
                this.tasks.add(new TaskDto(task));
            }
        }
    }
}
