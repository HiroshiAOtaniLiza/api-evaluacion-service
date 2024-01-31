package com.evaluacion.service.service;

import com.evaluacion.service.dto.AuthResponse;
import com.evaluacion.service.dto.LoginRequest;

public interface AuthService {

	AuthResponse login(LoginRequest request);

}
