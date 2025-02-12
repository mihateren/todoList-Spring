package com.example.todolist.web.dto.auth;

import lombok.Data;

@Data
public class JwtResponce {
    private Long id;
    private String username;
    private String accessToken;
    private String refreshToken;
}
