package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.portalaba.apirest.domain.Paciente;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>{

	@Query("select u from Paciente u where u.id = ?1")
	Paciente findByID(long id);
}
