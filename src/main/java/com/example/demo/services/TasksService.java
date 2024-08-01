package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.entities.*;

import com.example.demo.repos.TasksRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class TasksService {

    private final TasksRepo repo;

    public TasksService(TasksRepo repo){this.repo = repo;}

    public List<TaskDto> getAll() {
        List<TaskDto> dtos = new ArrayList<>();
        List<Tasks> found = this.repo.findAll();
        for(Tasks task : found){
            dtos.add(new TaskDto(task));
        }
        return dtos;
    }
    public ResponseEntity<?> getTask(Integer id) {
        Optional<Tasks> found = this.repo.findById(id);
        if(found.isEmpty()){
            return new ResponseEntity<>("No Task Found with id" + id, HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(new TaskDto(found.get()));
    }

    public ResponseEntity<?> removeTask(Integer id) {
        Optional<Tasks> found = this.repo.findById(id);
        if(found.isEmpty()) {
            return new ResponseEntity<>("No Task with id" + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Task Id " + id + " has been deleted");
    }

    public ResponseEntity<?> updateTask (Integer id, String taskDetail, Employee employee,String progress){
        Optional<Tasks> found = this.repo.findById(id);
        if(found.isEmpty()) {
            return new ResponseEntity<>("No Task with id " + id + " exists", HttpStatus.NOT_FOUND);
                    }
       Tasks toUpdate = found.get();

        if (employee != null) toUpdate.setEmployee(employee);
        if(taskDetail != null) toUpdate.setTaskDetail(taskDetail);
        if (progress != null) toUpdate.setProgress(progress);
        Tasks updated = this.repo.save(toUpdate);
        return ResponseEntity.ok(new TaskDto(updated));
    }

    public ResponseEntity<TaskDto> addTask(Tasks task) {
        Tasks created = this.repo.save(task);

        return new ResponseEntity<>(new TaskDto(created), HttpStatus.CREATED);
    }




}
