package com.portalaba.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalaba.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUserName(String username);
	
	Usuario findById(long idUser);
}
