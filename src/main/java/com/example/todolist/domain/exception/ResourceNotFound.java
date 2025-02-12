package com.example.todolist.domain.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) { super(message); }
}
