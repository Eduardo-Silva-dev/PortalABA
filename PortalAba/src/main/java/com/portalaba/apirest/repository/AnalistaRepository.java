package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

public interface AnalistaRepository extends JpaRepository<Analista, Long>{
	
	@Query("select u from Analista u where u.id = ?1")
	Analista findByID(long id);
	
	@Query("select u.acompanhantes from Analista u where u.id=?1")
	Page<Acompanhante> findAllAcompanhantes(long id,Pageable pageable );
	
	Page<Analista> findAll(Pageable pageable);
	
	@Query("select u from Analista u where u.empresas = ?1")
	Page<Analista> findAllAnalistas(long id, Pageable pageable);
	
	@Query("select u from Endereco u where u.id = ?1")
	Endereco findEnderecos(long id);
	
	@Query("select u.acompanhantes from Analista u where u.id=?1")
	Acompanhante findAcompanhante(long id);
	
	@Query("select u.pacientes from Analista u where u.id=?1")
	Paciente findPaciente(long id);
}
