package com.portalaba.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalaba.apirest.models.Usuario;
import com.portalaba.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@GetMapping
	public List<Usuario> listartodos(){
		return usuariorepository.findAll();
	}
	
	@GetMapping("{id}")
	public Usuario listar(@PathVariable(value="id")long id) {
		return usuariorepository.findById(id);
	}
}
