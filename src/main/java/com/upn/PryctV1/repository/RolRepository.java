package com.upn.PryctV1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upn.PryctV1.model.RolModel;

@Repository
public interface RolRepository extends JpaRepository<RolModel, Integer> {

    // JPQL
    @Query("SELECT r FROM RolModel r WHERE r.nombreRol LIKE %:nombreRol%")
    List<RolModel> buscarPorNombreJPQL(@Param("nombreRol") String nombreRol);

    // SQL Nativo MySQL
    @Query(value = "SELECT * FROM ROL WHERE nombre_rol LIKE CONCAT('%', :nombreRol, '%')",
           nativeQuery = true)
    List<RolModel> buscarPorNombreSQL(@Param("nombreRol") String nombreRol);

}