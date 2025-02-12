package com.example.todolist.service.impl;

import com.example.todolist.web.dto.auth.JwtRequest;
import com.example.todolist.web.dto.auth.JwtResponce;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements com.example.todolist.service.AuthService {
    @Override
    public JwtResponce login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponce refresh(String refreshToken) {
        return null;
    }
}
