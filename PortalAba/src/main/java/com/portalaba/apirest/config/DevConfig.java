package com.portalaba.apirest.config;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portalaba.apirest.service.DBService;
import com.portalaba.apirest.service.EmailService;
import com.portalaba.apirest.service.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
