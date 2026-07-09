package com.upn.PryctV1.dto;

public class ClienteDTO {

	private int codCliente;
	private int codUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String celular;
	private String direccion;

	public ClienteDTO() {

	}

	public ClienteDTO(int codCliente, int codUsuario, String nombre, String apellido, String email,
			String celular, String direccion) {
		this.codCliente = codCliente;
		this.codUsuario = codUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.celular = celular;
		this.direccion = direccion;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}