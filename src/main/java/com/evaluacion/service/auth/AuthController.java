package com.evaluacion.service.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.service.dto.FormatPassword;
import com.evaluacion.service.dto.LoginRequest;
import com.evaluacion.service.dto.UserRequest;
import com.evaluacion.service.exceptions.ExistException;
import com.evaluacion.service.exceptions.NotExistException;
import com.evaluacion.service.model.MUser;
import com.evaluacion.service.service.AuthService;
import com.evaluacion.service.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody UserRequest user) throws ExistException {
		MUser userFind = userService.getUser(user.getEmail());
		if (userFind != null) {
			throw new ExistException("El correo ya registrado");
		}
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@PostMapping("/saveFormatPassword")
	public ResponseEntity<?> saveFormatPassword(@RequestBody FormatPassword formatPassword) {
		return ResponseEntity.ok(userService.saveFormatPassword(formatPassword.getFormat()));
	}

	@PatchMapping("/getAll")
	public ResponseEntity<?> getAll() throws NotExistException {
		List<MUser> listUser = userService.AllUsers();
		if (listUser.isEmpty()) {
			throw new NotExistException("No hay Usuarios en la Base de Datos!");
		}
		return new ResponseEntity<>(listUser, HttpStatus.OK);
	}

	@GetMapping("/get/{email}")
	public ResponseEntity<?> getUserById(@PathVariable String email) throws NotExistException {
		MUser user = userService.getUser(email);
		if (user == null) {
			throw new NotExistException("El Usuario: ".concat(email).concat(" no existe en la base de datos!"));
		}
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

}
