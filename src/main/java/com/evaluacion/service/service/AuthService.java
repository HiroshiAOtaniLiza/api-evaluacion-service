package com.evaluacion.service.service;

import com.evaluacion.service.bean.AuthResponse;
import com.evaluacion.service.bean.LoginRequest;

public interface AuthService {

	AuthResponse login(LoginRequest request);

}
