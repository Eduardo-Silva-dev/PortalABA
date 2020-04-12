package com.portalaba.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.portalaba.apirest.domain.Analista;

public interface AnalistaRepository extends PagingAndSortingRepository<Analista, Long>{
	
	Analista findById(long id);
}
