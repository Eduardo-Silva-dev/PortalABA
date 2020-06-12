//package com.portalaba.apirest.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.portalaba.apirest.domain.Acompanhante;
//import com.portalaba.apirest.domain.Analista;
//import com.portalaba.apirest.domain.Empresa;
//import com.portalaba.apirest.domain.Paciente;
//import com.portalaba.apirest.repository.AcompanhanteRepository;
//import com.portalaba.apirest.repository.AnalistaRepository;
//import com.portalaba.apirest.repository.EmpresaRepository;
//import com.portalaba.apirest.repository.PacienteRepository;
//import com.portalaba.apirest.security.UserSS;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//	
//	@Autowired
//	private AnalistaRepository analistaRepository;
//	@Autowired
//	private EmpresaRepository empresaRepository;
//	@Autowired
//	private AcompanhanteRepository acompanhanteRepository;
//	@Autowired
//	private PacienteRepository pacienteRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Analista analista = analistaRepository.findByEmail(email);
//		if(analista == null) {
//			Empresa empresa = empresaRepository.findByEmail(email);
//			if(empresa == null) {
//				Acompanhante acompanhante = acompanhanteRepository.findByEmail(email);
//				if(acompanhante == null) {
//					Paciente paciente = pacienteRepository.findByEmail(email);
//					if(paciente == null) {
//						throw new UsernameNotFoundException(email);
//					}else {
//					return new UserSS(paciente.getId(),paciente.getEmailResponsavel(),paciente.getPassword(),paciente.getPerfis());}
//				}else {
//				return new UserSS(acompanhante.getId(),acompanhante.getEmailAcompanhante(),acompanhante.getPassword(),acompanhante.getPerfis());}
//			}else {
//			return new UserSS(empresa.getId(),empresa.getEmail(),empresa.getPassword(),empresa.getPerfis());}
//		}else {
//		return new UserSS(analista.getId(),analista.getEmailAnalista(),analista.getPassword(),analista.getPerfis());}
//	}
//}
