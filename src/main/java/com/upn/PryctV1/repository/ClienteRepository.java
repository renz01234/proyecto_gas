package com.upn.PryctV1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upn.PryctV1.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

	// Buscar el perfil de Cliente a partir del cod_usuario (clave para el login)
	Optional<ClienteModel> findByUsuario_CodUsuario(int codUsuario);

	// JPQL - búsqueda por nombre del usuario asociado
	@Query("SELECT c FROM ClienteModel c WHERE c.usuario.nombre LIKE %:nombre%")
	List<ClienteModel> buscarPorNombreJPQL(@Param("nombre") String nombre);

}