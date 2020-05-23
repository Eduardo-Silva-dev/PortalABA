package com.portalaba.apirest.service;

import org.springframework.mail.SimpleMailMessage;
import com.portalaba.apirest.domain.Tratamento;

public interface EmailService {

	void sendOrderConfirmationEmail(Tratamento obj);
	
	void sendEmail(SimpleMailMessage msg);
	
//	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
