package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taskDetail;
    @ManyToOne
    private Employee employee;
    private String progress;

    public Tasks(Integer id, String taskDetail, Employee employee, String progress) {
        this.id = id;
        this.taskDetail = taskDetail;
        this.employee = employee;
        this.progress = progress;
    }

    public Tasks() {super();
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
