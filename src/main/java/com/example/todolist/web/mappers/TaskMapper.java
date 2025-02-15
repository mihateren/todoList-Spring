package com.example.todolist.web.mappers;

import com.example.todolist.domain.task.Task;
import com.example.todolist.web.dto.task.TaskDto;

import java.util.List;

public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto taskDto);

}
