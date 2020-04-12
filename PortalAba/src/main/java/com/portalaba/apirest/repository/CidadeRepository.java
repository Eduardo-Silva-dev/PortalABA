package com.portalaba.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.portalaba.apirest.domain.Cidade;

@Repository
public interface CidadeRepository  extends PagingAndSortingRepository<Cidade, Long> {

}
