package com.madara.security.authentication;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
