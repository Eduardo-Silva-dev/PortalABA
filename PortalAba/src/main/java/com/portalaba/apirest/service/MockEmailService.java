package com.portalaba.apirest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.mail.SimpleMailMessage;

import com.portalaba.apirest.domain.Tratamento;

public class MockEmailService extends AbstractEmailService  {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}

	@Override
	public void sendOrderConfirmationEmail(Tratamento obj) {
		// TODO Auto-generated method stub
		
	}

}