package com.portalaba.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.portalaba.apirest.domain.Tratamento;

public interface TratamentoRepository extends JpaRepository<Tratamento, Long>{

	@Query("select u from Tratamento u where u.analista = ?1 AND u.paciente = ?2")
	Page<Tratamento> findTratamentos(long id,long idP,Pageable pageable);
	
	@Query("select u from Tratamento u where u.id = ?1")
	Tratamento findByID(long id);
}