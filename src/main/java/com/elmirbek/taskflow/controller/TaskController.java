package com.elmirbek.taskflow.controller;


import com.elmirbek.taskflow.entity.Task;
import com.elmirbek.taskflow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/L")
    public List<Task> getAllTasks (){
        return taskService.getAllTasks();
    }
}
