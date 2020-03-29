package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalaba.apirest.models.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long>{
	
	Clientes findById(long id);
}
