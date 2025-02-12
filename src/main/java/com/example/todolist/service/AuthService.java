package com.example.todolist.service;

import com.example.todolist.web.dto.auth.JwtRequest;
import com.example.todolist.web.dto.auth.JwtResponce;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    JwtResponce login(JwtRequest loginRequest);

    JwtResponce refresh(String refreshToken);
}
