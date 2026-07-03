package com.upn.PryctV1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upn.PryctV1.model.ProductoModel;
 
@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer> {

    // JPQL
    @Query("SELECT p FROM ProductoModel p WHERE p.nomMarca LIKE %:nomMarca%")
    List<ProductoModel> buscarPorNombreJPQL(@Param("nomMarca") String nomMarca);

    // SQL Nativo MySQL
    @Query(value = "SELECT * FROM PRODUCTO WHERE nombre_marca LIKE CONCAT('%', :nomMarca, '%')",
           nativeQuery = true)
    List<ProductoModel> buscarPorNombreSQL(@Param("nomMarca") String nomMarca);

}