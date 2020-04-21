package com.portalaba.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Paciente;

public interface AnalistaRepository extends CrudRepository<Analista, Long>{
	
	@Query("select u from Analista u where u.id = ?1")
	Analista findByID(long id);
	
	@Query("select u.pacientes from Analista u where u.id = ?1")
	List<Paciente> findAllPacientes (long id);

	@Query("select u.acompanhantes from Analista u where u.id = ?1")
	List<Acompanhante> findAllAcompanhantes(long id);
}
