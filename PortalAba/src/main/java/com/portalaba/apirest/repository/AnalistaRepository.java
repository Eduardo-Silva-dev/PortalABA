package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.PacienteDTO;

public interface AnalistaRepository extends CrudRepository<Analista, Long>{
	
	@Query("select u from Analista u where u.id = ?1")
	Analista findByID(long id);
	
	@Query("select u.pacientes from Analista u where u.id = ?1")
	Page<PacienteDTO> findAllPacientes(long id,Pageable pageable);
	
	@Query("select u.acompanhantes from Analista u where u.id = ?1")
	Page<AcompanhanteDTO> findAllAcompanhantes(long id,Pageable pageable);
	
	Page<Analista> findAll(Pageable pageable);
	
	@Query("select u from Endereco u where u.id = ?1")
	Endereco findEnderecos(long id);
}
