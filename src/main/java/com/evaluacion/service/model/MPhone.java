package com.evaluacion.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="phone")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MPhone {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
	
	@Column(name = "number", nullable = false)
	private String number;
	
	@Column(name = "citycode", nullable = false)
	private String citycode;
	
	@Column(name = "contrycode", nullable = false)
	private String contrycode;
	
}
