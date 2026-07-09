package com.upn.PryctV1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.PryctV1.dto.RolDTO;
import com.upn.PryctV1.model.RolModel;
import com.upn.PryctV1.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;

    // Convertir de Model a DTO
    public RolDTO convertirDTO(RolModel r) {
        RolDTO dto = new RolDTO();
        dto.setCodRol(r.getCodRol());
        dto.setNombreRol(r.getNombreRol());
        return dto;
    }

    // Listar todos los roles
    public List<RolDTO> listar() {
        List<RolModel> lista = repository.findAll();
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public RolModel getRol(int id) {
        RolModel r = repository.findById(id).orElse(null);
        return r;
    }

    // Guardar
    public RolModel saveRol(RolModel r) {
        return repository.save(r);
    }

    // Eliminar
    public void deleteRol(int id) {
        repository.deleteById(id);
    }

    // Buscar por nombre (JPQL)
    public List<RolDTO> buscarPorNombreJPQL(String nombreRol) {
        List<RolModel> lista = repository.buscarPorNombreJPQL(nombreRol);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por nombre (SQL Nativo)
    public List<RolDTO> buscarPorNombreSQL(String nombreRol) {
        List<RolModel> lista = repository.buscarPorNombreSQL(nombreRol);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

}