package com.upn.PryctV1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROL")
public class RolModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_rol")
	private int codRol;
	
	@Column(name="nombre_rol")
	private String nombreRol;
	
	public RolModel() {
		
	}

	public int getCodRol() {
		return codRol;
	}

	public void setCodRol(int codRol) {
		this.codRol = codRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
}