package com.example.todolist.web.controller;

import com.example.todolist.domain.task.Task;
import com.example.todolist.domain.user.User;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.UserService;
import com.example.todolist.web.dto.task.TaskDto;
import com.example.todolist.web.dto.user.UserDto;
import com.example.todolist.web.dto.validation.OnCreate;
import com.example.todolist.web.dto.validation.OnUpdate;
import com.example.todolist.web.mappers.TaskMapper;
import com.example.todolist.web.mappers.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        logger.info("Received request to get user with id: {}", id);

        User user = userService.getById(id);

        if (user == null) {
            logger.warn("User with id {} not found", id);
        } else {
            logger.info("User with id {} found: {}", id, user);
        }

        UserDto userDto = userMapper.toDto(user);
        logger.info("Mapped user to UserDto: {}", userDto);

        return userDto;
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id,
                              @Validated(OnCreate.class) @RequestBody  TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

    @PutMapping
    public UserDto updateUser(@Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        User user = userService.getById(id);
    }



}
