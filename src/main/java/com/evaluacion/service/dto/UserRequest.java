package com.evaluacion.service.dto;

import java.util.List;

import com.evaluacion.service.model.MPhone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private List<MPhone> phones;
	
}
