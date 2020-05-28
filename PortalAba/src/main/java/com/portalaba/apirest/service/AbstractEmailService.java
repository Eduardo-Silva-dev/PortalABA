package com.portalaba.apirest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.portalaba.apirest.domain.Tratamento;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Tratamento obj,String destinatario, String paciente) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromTratamento(obj,destinatario,paciente);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromTratamento(Tratamento obj,String destinatario, String paciente) {
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(destinatario);
		sm.setFrom(sender);
		sm.setSubject("Novo tratamento para o Paciente " + paciente);
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	

}