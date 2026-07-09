package com.upn.PryctV1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="USUARIO")
public class UsuarioModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_usuario")
	private int codUsuario;
	
	@NotNull(message = "Debe seleccionar un rol")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_rol", nullable = false,
			foreignKey = @jakarta.persistence.ForeignKey(name = "FK_USUARIO_ROL"))
	private RolModel rol;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 100)
	@Column(name="nombre")
	private String nombre;

	@NotBlank(message = "El apellido es obligatorio")
	@Size(max = 100)
	@Column(name="apellido")
	private String apellido;

	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "Correo inválido")
	@Column(name="email")
	private String email;

	@NotBlank(message = "La contraseña es obligatoria")
	@Size(min = 6, message = "Debe tener al menos 6 caracteres")
	@Column(name="password")
	private String password;
	
	@Column(name="activo")
	private boolean activo;
	
	public UsuarioModel(){
		
	}

	public int getCodUsuario(){
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario){
		this.codUsuario = codUsuario;
	}

	public RolModel getRol() {
		return rol;
	}

	public void setRol(RolModel rol){
		this.rol = rol;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido(){
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public boolean isActivo(){
		return activo;
	}

	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	
}