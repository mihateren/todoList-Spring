package com.example.todolist.repository;

import com.example.todolist.domain.user.Role;
import com.example.todolist.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(Long userId, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);
}
