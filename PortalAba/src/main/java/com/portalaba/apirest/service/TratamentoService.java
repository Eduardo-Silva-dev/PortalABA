package com.portalaba.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portalaba.apirest.repository.TratamentoRepository;
import com.portalaba.apirest.domain.Tratamento;

@Service
public class TratamentoService {
	
	@Autowired
	private TratamentoRepository repo;

	public Tratamento findTratamento(long id) {
		Tratamento tratamento = repo.findByID(id);
		return tratamento;
	}
	
	public void save (Tratamento tratamento) {
		repo.save(tratamento);
	}
}
