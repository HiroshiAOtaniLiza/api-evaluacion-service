package com.evaluacion.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.evaluacion.service.bean.AuthResponse;
import com.evaluacion.service.bean.UserRequest;
import com.evaluacion.service.dao.UserRepository;
import com.evaluacion.service.model.MUser;
import com.evaluacion.service.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userDao;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	@Override
	public List<MUser> AllUsers() {
		return userDao.findAll();
	}

	@Override
	public MUser getUser(String id) {
		Optional<MUser> result = userDao.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public AuthResponse saveUser(UserRequest request) {
		
		MUser user = MUser.builder()
							.email(request.getEmail())
							.name(request.getName())
							.password(passwordEncoder.encode(request.getPassword())).build();

		userDao.save(user);

		return AuthResponse.builder().token(jwtService.getToken(user)).build();
	}

}
