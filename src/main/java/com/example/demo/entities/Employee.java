package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String surname;

    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tasks> tasks;

    public Employee(Integer id, String firstName, String surname) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Employee() {
    }

    public Employee(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Employee(Integer id, String firstName, String surname, List<Tasks> tasks) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.tasks = tasks;
    }

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

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
