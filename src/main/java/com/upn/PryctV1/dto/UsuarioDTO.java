package com.upn.PryctV1.dto;

public class UsuarioDTO {
	
	private int codUsuario;
	private int codRol;
	private String nombreRol;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private boolean activo;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(int codUsuario, int codRol, String nombreRol, String nombre, String apellido, String email,
			String password, boolean activo) {
		this.codUsuario = codUsuario;
		this.codRol = codRol;
		this.nombreRol = nombreRol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.activo = activo;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}