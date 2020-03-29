package com.biblioteca.portalAba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.portalAba.models.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long>{
	
	Clientes findById(long id);
}
