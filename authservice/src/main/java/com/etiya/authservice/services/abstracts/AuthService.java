package com.etiya.authservice.services.abstracts;

import com.etiya.authservice.services.dtos.LoginRequest;
import com.etiya.authservice.services.dtos.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest registerRequest);

    String login(LoginRequest loginRequest);
}
