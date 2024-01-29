package com.evaluacion.service.service;

import java.util.List;

import com.evaluacion.service.bean.AuthResponse;
import com.evaluacion.service.bean.UserRequest;
import com.evaluacion.service.exceptions.ExistException;
import com.evaluacion.service.model.MFormatPassword;
import com.evaluacion.service.model.MUser;

public interface UserService {
	
	List<MUser> AllUsers();
	
	MUser getUser(String id);
	
	AuthResponse saveUser(UserRequest user) throws ExistException;
	
	MFormatPassword saveFormatPassword(MFormatPassword formatPassword);

}
