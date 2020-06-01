package com.portalaba.apirest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Empresa;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("select u.analistas from Empresa u where u.id =?1")
	Page<Analista> findAllAnalistas(long id, Pageable pageable);

	@Query("select u.acompanhantes from Empresa u where u.id=?1")
	Page<Acompanhante> findAllAcompanhante(long id, Pageable pageable);
	
	@Query("select u.pacientes from Empresa u where u.id=?1")
	Page<Paciente> findAllPaciente(long id, Pageable pageable);
	
	@Query("select u from Empresa u where u.id = ?1")
	Empresa findByID(long id);
	
	@Query("select u from Endereco u where u.id = ?1")
	Endereco findEnderecos(long id);
	
	@Query("select u.analistas from Empresa u where u.id=?1")
	Analista findAnalista(long id);
	
	@Query("select u.acompanhantes from Empresa u where u.id=?1")
	Acompanhante findAcompanhante(long id);
	
	@Query("select u.pacientes from Empresa u where u.id=?1")
	Paciente findPaciente(long id);
}