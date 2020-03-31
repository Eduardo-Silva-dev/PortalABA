package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalaba.apirest.models.Analista;

public interface AnalistaRepository extends JpaRepository<Analista, Long>{
	
	Analista findById(long id);
}
