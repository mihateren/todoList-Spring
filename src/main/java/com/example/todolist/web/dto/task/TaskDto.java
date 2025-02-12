package com.example.todolist.web.dto.task;


import com.example.todolist.domain.task.Status;
import com.example.todolist.web.dto.validation.OnCreate;
import com.example.todolist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class TaskDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "Title must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Title length must be less than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String title;

    @NotNull(message = "Description must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Description length must be less than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String description;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creationDate;
}
