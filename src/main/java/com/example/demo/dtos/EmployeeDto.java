package com.example.demo.dtos;
import com.example.demo.entities.*;
import org.hibernate.sql.model.ast.builder.TableUpdateBuilderSkipped;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String surname;

    private List<TaskDto> tasks = new ArrayList<>();

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

    public EmployeeDto() {
    }

    public EmployeeDto(List<TaskDto> tasks){super ();}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
