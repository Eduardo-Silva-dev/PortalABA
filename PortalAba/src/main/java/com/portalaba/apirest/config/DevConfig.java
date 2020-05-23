package com.portalaba.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portalaba.apirest.service.EmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	
//	@Bean
//	public EmailService emailService() {
//		return new SmtpEmailService();
//	}
}
