package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalaba.apirest.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	
}
