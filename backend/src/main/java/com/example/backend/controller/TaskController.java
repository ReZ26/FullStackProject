package com.example.backend.controller;

import com.example.backend.model.Task;
import com.example.backend.model.User;
import com.example.backend.service.TaskService;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Task> getTasks(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).get();
        return taskService.getTasksByUser(user);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).get();
        task.setUser(user);
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask, @AuthenticationPrincipal UserDetails userDetails) {
        Task task = taskService.findById(id).orElseThrow();
        if (!task.getUser().getUsername().equals(userDetails.getUsername())) throw new RuntimeException("Unauthorized");
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Task task = taskService.findById(id).orElseThrow();
        if (!task.getUser().getUsername().equals(userDetails.getUsername())) throw new RuntimeException("Unauthorized");
        taskService.delete(task);
    }
} 