package com.example.demo.dtos;
import com.example.demo.dtos.*;
import com.example.demo.entities.*;

public class TaskDto {
    private Integer id;
    private String taskDetail;
    private String progress;


    public TaskDto(Tasks task) {
        this.id = task.getId();
        this.taskDetail = task.getTaskDetail();
        this.progress = task.getProgress();
    }

    public TaskDto(Integer id, String taskDetail, String progress) {
        this.id = id;
        this.taskDetail = taskDetail;
        this.progress = progress;
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

    public TaskDto() {
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
}
