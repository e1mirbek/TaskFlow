package com.elmirbek.taskflow.service;


import com.elmirbek.taskflow.entity.Task;
import com.elmirbek.taskflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

  public   List<Task> getAllTasks () {
        return taskRepository.findAll();
    }

    public Task getTaskById (Long id) {
    return   taskRepository.findById(id).orElse(null);
    }

    public void saveTask (Task task) {
      taskRepository.save(task);
    }

    public void deleteTask (Long id) {
      taskRepository.deleteById(id);
    }

    public  List<Task> getTasksByUser_Username (String username) {
      return taskRepository.findTasksByUser_Username(username);
    }


}
