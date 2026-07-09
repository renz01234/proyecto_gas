package com.upn.PryctV1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upn.PryctV1.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    // JPQL
    @Query("SELECT u FROM UsuarioModel u WHERE u.nombre LIKE %:nombre%")
    List<UsuarioModel> buscarPorNombreJPQL(@Param("nombre") String nombre);

    // SQL Nativo
    @Query(value = "SELECT * FROM USUARIO WHERE nombre LIKE CONCAT('%', :nombre, '%')",
           nativeQuery = true)
    List<UsuarioModel> buscarPorNombreSQL(@Param("nombre") String nombre);

    // Buscar por email (Login)
    UsuarioModel findByEmail(String email);

}