package com.evaluacion.service.auth;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.evaluacion.service.dto.LoginRequest;
import com.evaluacion.service.dto.UserRequest;
import com.evaluacion.service.model.MPhone;
import com.evaluacion.service.service.AuthService;
import com.evaluacion.service.service.UserService;
import com.evaluacion.service.service.impl.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

@WebMvcTest(controllers = AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class AuthControllerTests {
	
	private static final String END_POINT_PATH = "/auth";

	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;
	
	@MockBean private UserService userService;
	@MockBean private AuthService authService;
	@MockBean private JwtService jwtService;
	
	private UserRequest userRequest;
	
	@BeforeEach
	public void init() {
		List<MPhone> phones = new ArrayList<>();
		phones.add(MPhone.builder().citycode("1").number("12345699").contrycode("57").build());
		phones.add(MPhone.builder().citycode("2").number("12345677").contrycode("58").build());
		userRequest = UserRequest.builder().email("pablo7gmail.com").name("Pablo").password("12345").phones(phones).build();
	}
	
	@Test
	public void testSaveReturn200Ok() throws Exception {
		
		String requestBody = objectMapper.writeValueAsString(userRequest);
		
		mockMvc.perform(post(END_POINT_PATH.concat("/save")).contentType("application/json")
				.content(requestBody))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testLoginReturn200OK() throws Exception {
		
		LoginRequest loginRequest = LoginRequest.builder().username("sadas").password("asdasd").build();
		
		String requestBody = objectMapper.writeValueAsString(loginRequest);
		
		mockMvc.perform(post(END_POINT_PATH.concat("/login")).contentType("application/json")
				.content(requestBody))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
}
