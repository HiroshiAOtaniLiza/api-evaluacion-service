package com.evaluacion.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluacion.service.model.MFormatPassword;

public interface FormatPasswordRepository extends JpaRepository<MFormatPassword, Integer> {
	
}
