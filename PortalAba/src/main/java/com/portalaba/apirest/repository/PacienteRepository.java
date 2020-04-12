package com.portalaba.apirest.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.portalaba.apirest.domain.Paciente;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>{
	
	Paciente findById(long id);
}
