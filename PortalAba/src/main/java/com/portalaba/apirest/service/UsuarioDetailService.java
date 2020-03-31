package com.portalaba.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;
import com.portalaba.apirest.models.Usuario;
import com.portalaba.apirest.repository.UsuarioRepository;

@Component
public class UsuarioDetailService implements UserDetailsService  {

	private final UsuarioRepository usuariorepository;
	
	@Autowired
	public UsuarioDetailService(UsuarioRepository usuariorepository) {
		this.usuariorepository = usuariorepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = Optional.ofNullable(usuariorepository.findByUserName(username))
				.orElseThrow(() -> new UsernameNotFoundException ("Usuario não encontrado"));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("Role_USER","Role_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("Role_USER");
		return new User(usuario.getUserName(),usuario.getPassword(),usuario.getNivel() ? authorityListAdmin  : authorityListUser);
	}

}
