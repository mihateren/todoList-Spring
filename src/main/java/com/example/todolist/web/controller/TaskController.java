package com.example.todolist.web.controller;

import com.example.todolist.domain.task.Task;
import com.example.todolist.service.TaskService;
import com.example.todolist.web.dto.task.TaskDto;
import com.example.todolist.web.dto.validation.OnCreate;
import com.example.todolist.web.dto.validation.OnUpdate;
import com.example.todolist.web.mappers.TaskMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Validated
@Tag(name = "Task Controller", description = "Task API")
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);


    @GetMapping("/{id}")
    @Operation(summary = "Get task by id")
    public TaskDto getTask(@PathVariable Long id) {
        Task task = taskService.getById(id);
        logger.debug("Get task: {}", task);
        TaskDto taskDto = taskMapper.toDto(task);
        logger.debug("Mapped Task to TaskDto: {}", taskDto);
        return taskDto;
    }

    @PutMapping
    @Operation(summary = "Update task")
    public TaskDto updateTask(@Validated(OnUpdate.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete task by id")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Create task by userId")
    public TaskDto createTask(
            @Parameter(description = "User ID to associate the task with")
            @PathVariable Long id,
            @Validated(OnCreate.class)
            @RequestBody TaskDto taskDto
    ) {
        Task task = taskMapper.toEntity(taskDto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

}
