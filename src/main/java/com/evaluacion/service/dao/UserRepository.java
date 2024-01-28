package com.evaluacion.service.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluacion.service.model.MUser;

public interface UserRepository extends JpaRepository<MUser, String> {

	Optional<MUser> findOneByEmail(String email);
	
}
