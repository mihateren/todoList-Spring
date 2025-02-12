package com.example.todolist.service;

import com.example.todolist.domain.task.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {
    Task getById(Long id);

    List<Task> getAllByUserId(Long userId);

    Task update(Task task);

    Task create(Task task, Long userId);

    void delete(Long id);
}
