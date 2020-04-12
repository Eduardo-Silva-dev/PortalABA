package com.portalaba.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.portalaba.apirest.domain.Estado;

@Repository
public interface EstadoRepository extends PagingAndSortingRepository<Estado, Long> {

}
