package com.evaluacion.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="format_password")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MFormatPassword {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "format", nullable = false)
	private String format;
	
}
