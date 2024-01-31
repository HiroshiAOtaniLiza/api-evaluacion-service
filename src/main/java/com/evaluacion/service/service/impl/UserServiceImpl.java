package com.evaluacion.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.evaluacion.service.dao.FormatPasswordRepository;
import com.evaluacion.service.dao.UserRepository;
import com.evaluacion.service.dto.AuthResponse;
import com.evaluacion.service.dto.UserRequest;
import com.evaluacion.service.exceptions.ExistException;
import com.evaluacion.service.model.MFormatPassword;
import com.evaluacion.service.model.MUser;
import com.evaluacion.service.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private FormatPasswordRepository formatPasswordDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;

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
	public AuthResponse saveUser(UserRequest request) throws ExistException {
		
		if(!request.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
			throw new IllegalArgumentException("Correo con mal formato");
		}
		if(!request.getPassword().matches(formatPasswordDao.findById(1).get().getFormat())) {
			throw new IllegalArgumentException("Password con mal formato");
		}
		
		MUser user = MUser.builder()
							.email(request.getEmail())
							.name(request.getName())
							.password(passwordEncoder.encode(request.getPassword()))
							.phones(request.getPhones()).build();

		userDao.save(user);

		return AuthResponse.builder().token(jwtService.getToken(user)).build();
	}

	@Override
	public MFormatPassword saveFormatPassword(String formatPassword) {
		MFormatPassword fPassword = MFormatPassword.builder().id(1).format(formatPassword).build();
		return formatPasswordDao.save(fPassword);
	}

}
