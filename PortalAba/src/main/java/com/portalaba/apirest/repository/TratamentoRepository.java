package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portalaba.apirest.domain.Tratamento;

public interface TratamentoRepository extends JpaRepository<Tratamento, Long>{

	@Query("select u from Tratamento u where u.paciente = ?1 AND u.tipo=?2")
	Page<Tratamento> findTratamentos(long id,String tipo,Pageable pageable);
	
	@Query("select u from Tratamento u where u.id = ?1")
	Tratamento findByID(long id);
}