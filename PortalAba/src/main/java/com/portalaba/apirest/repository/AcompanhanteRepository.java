package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;

public interface AcompanhanteRepository extends JpaRepository<Acompanhante, Long>{
	
	@Query("select u from Acompanhante u where u.id = ?1")
	Acompanhante findByID(long id);

	Page<Acompanhante> findAll(Pageable pageable);
	
	@Query("select u.pacientes from Acompanhante u where u.id = ?1")
	Page<PacienteDTO> findAllPacientes(long id,Pageable pageable);

	@Query("select u.analistas from Acompanhante u where u.id = ?1")
	Page<AnalistaDTO> findAllAnalistas(long id,Pageable pageable);	
	
	@Query("select u from Endereco u where u.id = ?1")
	Endereco findEnderecos(long id);
}
