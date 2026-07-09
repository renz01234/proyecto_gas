package com.upn.PryctV1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.PryctV1.dto.ClienteDTO;
import com.upn.PryctV1.model.ClienteModel;
import com.upn.PryctV1.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	// Convertir de Model a DTO
	public ClienteDTO convertirDTO(ClienteModel c) {
		ClienteDTO dto = new ClienteDTO();
		dto.setCodCliente(c.getCodCliente());
		dto.setCodUsuario(c.getUsuario().getCodUsuario());
		dto.setNombre(c.getUsuario().getNombre());
		dto.setApellido(c.getUsuario().getApellido());
		dto.setEmail(c.getUsuario().getEmail());
		dto.setCelular(c.getCelular());
		dto.setDireccion(c.getDireccion());
		return dto;
	}

	// Listar todos los clientes
	public List<ClienteDTO> listar() {
		return repository.findAll().stream()
				.map(this::convertirDTO)
				.collect(Collectors.toList());
	}

	// Buscar por ID de cliente
	public ClienteModel getCliente(int id) {
		return repository.findById(id).orElse(null);
	}

	// Buscar el perfil de Cliente a partir del cod_usuario (para el login)
	public ClienteModel getClientePorUsuario(int codUsuario) {
		return repository.findByUsuario_CodUsuario(codUsuario).orElse(null);
	}

	// Guardar
	public ClienteModel saveCliente(ClienteModel c) {
		return repository.save(c);
	}

	// Eliminar
	public void deleteCliente(int id) {
		repository.deleteById(id);
	}

	// Buscar por nombre (JPQL, a través del usuario asociado)
	public List<ClienteDTO> buscarPorNombreJPQL(String nombre) {
		return repository.buscarPorNombreJPQL(nombre).stream()
				.map(this::convertirDTO)
				.collect(Collectors.toList());
	}

}