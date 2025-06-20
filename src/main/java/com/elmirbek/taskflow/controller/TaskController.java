package com.elmirbek.taskflow.controller;


import com.elmirbek.taskflow.entity.Task;
import com.elmirbek.taskflow.entity.User;
import com.elmirbek.taskflow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
     public String index (Model model, Principal principal){
        String username = principal.getName();
        List <Task> tasks = taskService.getTasksByUser_Username(username);
        System.out.println("Количество задач : " + tasks.size());
        model.addAttribute("tasks", tasks);
        return "task-list";
    }


    // добавитьт задачу
    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    // сохранить задачу
    @PostMapping("/save")
    public String saveTask (@ModelAttribute("task") Task task, @AuthenticationPrincipal User user) {
        task.setUser(user);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    // Удалить задачу
    @GetMapping("/delete/{id}")
    public String deleteTask (@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    // Изменить статус задачи
    @GetMapping("/toggle-status/{id}")
    public String toggleStatus (@PathVariable("id") Long id) {
        Task task = taskService.getTaskById(id);
        task.setCompleted(!task.getCompleted());
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    // Редактировать задачу
    @GetMapping("/edit/{id}")
    public String editTask (@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return  "task-form";
    }




}
