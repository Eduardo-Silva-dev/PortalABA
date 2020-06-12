package com.portalaba.apirest.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import com.portalaba.apirest.domain.Tratamento;

public interface EmailService {

	void sendOrderConfirmationEmail(Tratamento obj);
	
	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationEmail(Tratamento obj, String destinatario, String paciente);

	void sendOrderConfirmationHtmlEmail(Tratamento obj, String destinatario, String paciente);
	
	void sendHtmlEmail(MimeMessage mm);
}
