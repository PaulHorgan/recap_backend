package com.example.demo.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.*;
import com.example.demo.services.*;
import com.example.demo.entities.*;
import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController


public class TaskController {
private final TasksService service;

public TaskController(TasksService service){
    this.service = service;
}
@GetMapping("tasks/getAll")
    public List<TaskDto> getAllTasks() {
    return this.service.getAll();
}
    @GetMapping ("task/get/{id}")
    public ResponseEntity<?> getEmployeeById (@PathVariable Integer id){
    return this.service.getTask(id);
    }

    @GetMapping("tasks/add")
    public ResponseEntity<TaskDto> createTask(@RequestBody Tasks newTask){
    return this.service.addTask(newTask);
    }

    @GetMapping("tasks/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Integer id, @RequestBody Tasks updateRequest){
    return this.service.updateTask(id,
            updateRequest.getTaskDetail(),
            updateRequest.getEmployee(),
            updateRequest.getProgress());
    }

    @GetMapping("tasks/remove/{id}")
    public ResponseEntity<?> removeTask(@PathVariable Integer id){
    return service.removeTask(id);
    }

}
