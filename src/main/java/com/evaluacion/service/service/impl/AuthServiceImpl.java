package com.evaluacion.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.evaluacion.service.bean.AuthResponse;
import com.evaluacion.service.bean.LoginRequest;
import com.evaluacion.service.dao.UserRepository;
import com.evaluacion.service.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user=userRepository.findOneByEmail(request.getUsername()).orElseThrow();
		String token=jwtService.getToken(user);
		return AuthResponse.builder().token(token).build();
	}

}
