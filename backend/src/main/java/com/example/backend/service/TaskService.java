package com.example.backend.service;

import com.example.backend.model.Task;
import com.example.backend.model.User;
import com.example.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
} 