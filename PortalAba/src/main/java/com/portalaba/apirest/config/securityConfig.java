package com.portalaba.apirest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.portalaba.apirest.service.UsuarioDetailService;

@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true)
public class securityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private UsuarioDetailService usuarioDetailService;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}
		
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
