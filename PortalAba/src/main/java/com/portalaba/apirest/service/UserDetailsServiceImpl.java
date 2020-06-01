package com.portalaba.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AnalistaRepository analistaRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Analista analista = analistaRepository.findByEmail(email);
		if(analista == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(analista.getId(),analista.getEmailAnalista(),analista.getPassword(),analista.getPerfis());
	}
	
	

}
