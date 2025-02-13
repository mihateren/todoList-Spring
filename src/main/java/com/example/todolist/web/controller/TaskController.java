package com.example.todolist.web.controller;

import com.example.todolist.domain.task.Task;
import com.example.todolist.service.TaskService;
import com.example.todolist.web.dto.task.TaskDto;
import com.example.todolist.web.dto.validation.OnUpdate;
import com.example.todolist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);


    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        Task task = taskService.getById(id);
        logger.debug("Get task: {}", task);
        TaskDto taskDto = taskMapper.toDto(task);
        logger.debug("Mapped Task to TaskDto: {}", taskDto);
        return taskDto;
    }

    @PutMapping
    public TaskDto updateTask(@Validated(OnUpdate.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

}
