package com.upn.PryctV1.dto;

public class RolDTO {
	private int codRol;
	private String nombreRol;

	public RolDTO() {
		
	}

	public RolDTO(int codRol, String nombreRol) {
		super();
		this.codRol = codRol;
		this.nombreRol = nombreRol;
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
