package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalaba.apirest.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	Paciente findById(long id);
}
