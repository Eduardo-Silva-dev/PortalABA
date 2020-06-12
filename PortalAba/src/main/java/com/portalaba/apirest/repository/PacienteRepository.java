package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Empresa;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>{

	@Query("select u from Paciente u where u.id = ?1")
	Paciente findByID(long id);
	
	@Query("select u from Endereco u where u.id = ?1")
	Endereco findEnderecos(long id);
	
	@Query("select u from Paciente u where u.emailResponsavel = ?1")
	Paciente findByEmail(String email);
	
	@Query("select u from Paciente u where u.analista = ?1")
	Page<Paciente> findAllPacientes(Analista id,Pageable pageable);
	
	@Query("select u from Paciente u where u.analista = ?1 and u.empresa=?2")
	Page<Paciente> findPacientesAnalista(Analista id,Empresa idE,Pageable pageable);
	
//	@Query("select u from Paciente u where u.acomapanhante = ?1 and u.empresa=?2")
//	Page<Paciente> findPacientesAcompanhante(Acompanhante id,Empresa idE,Pageable pageable);
}
