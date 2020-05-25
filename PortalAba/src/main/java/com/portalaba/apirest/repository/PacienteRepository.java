package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.dto.PacienteDTO;
import org.springframework.data.domain.Pageable;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>{

	@Query("select u from Paciente u where u.id = ?1")
	Paciente findByID(long id);
	
	@Query("select u from Endereco u where u.id = ?1")
	Endereco findEnderecos(long id);
	
	@Query("select u from Paciente u where u.analista = ?1")
	Page<PacienteDTO> findAllPacientes(Analista id,Pageable pageable);
}
