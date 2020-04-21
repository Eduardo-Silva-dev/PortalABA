package com.portalaba.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

public interface AcompanhanteRepository extends PagingAndSortingRepository<Acompanhante, Long>{
	
	@Query("select u from Acompanhante u where u.id = ?1")
	Acompanhante findByID(long id);

	@Query("select u.pacientes from Acompanhante u where u.id = ?1")
	List<Paciente> findAllPacientes(long id);

	@Query("select u.analistas from Acompanhante u where u.id = ?1")
	List<Analista> findAllAnalistas(long id);
	
	@Query("select u from Endereco u where u.acompanhante = 3")
	Endereco findEnderecos(Acompanhante id);
}
