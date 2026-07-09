package com.upn.PryctV1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente")
	private int codCliente;

	@NotNull(message = "Debe indicar el usuario asociado")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_usuario", nullable = false, unique = true,
			foreignKey = @jakarta.persistence.ForeignKey(name = "FK_CLIENTE_USUARIO"))
	private UsuarioModel usuario;

	@Size(max = 15)
	@Column(name = "celular")
	private String celular;

	@Size(max = 150)
	@Column(name = "direccion")
	private String direccion;

	public ClienteModel() {

	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
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