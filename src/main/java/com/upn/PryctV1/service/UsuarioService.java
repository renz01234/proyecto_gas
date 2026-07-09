package com.upn.PryctV1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.PryctV1.dto.UsuarioDTO;
import com.upn.PryctV1.model.UsuarioModel;
import com.upn.PryctV1.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Convertir de Model a DTO
    public UsuarioDTO convertirDTO(UsuarioModel u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCodUsuario(u.getCodUsuario());
        dto.setCodRol(u.getRol().getCodRol());
        dto.setNombreRol(u.getRol().getNombreRol());
        dto.setNombre(u.getNombre());
        dto.setApellido(u.getApellido());
        dto.setEmail(u.getEmail());
        dto.setPassword(u.getPassword());
        dto.setActivo(u.isActivo());
        return dto;
    }

    // Listar todos los usuarios
    public List<UsuarioDTO> listar() {
        List<UsuarioModel> lista = repository.findAll();
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public UsuarioModel getUsuario(int id) {
        return repository.findById(id).orElse(null);
    }

    // Guardar
    public UsuarioModel saveUsuario(UsuarioModel u) {
        return repository.save(u);
    }

    // Eliminar
    public void deleteUsuario(int id) {
        repository.deleteById(id);
    }

    // Buscar por nombre (JPQL)
    public List<UsuarioDTO> buscarPorNombreJPQL(String nombre) {
        List<UsuarioModel> lista = repository.buscarPorNombreJPQL(nombre);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por nombre (SQL Nativo)
    public List<UsuarioDTO> buscarPorNombreSQL(String nombre) {
        List<UsuarioModel> lista = repository.buscarPorNombreSQL(nombre);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por email (para Login)
    public UsuarioModel buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

}