package com.portalaba.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.portalaba.apirest.domain.Acompanhante;

public interface AcompanhanteRepository extends PagingAndSortingRepository<Acompanhante, Long>{
	
	Acompanhante findById(long id);
}
