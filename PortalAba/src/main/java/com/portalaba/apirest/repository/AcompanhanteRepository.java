package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalaba.apirest.models.Acompanhante;

public interface AcompanhanteRepository extends JpaRepository<Acompanhante, Long>{
	
	Acompanhante findById(long id);
}
