package com.portalaba.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.portalaba.apirest.domain.Endereco;

@Repository
public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, Long> {

}
