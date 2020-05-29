package com.portalaba.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.portalaba.apirest.domain.Empresa;

public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Long> {

}