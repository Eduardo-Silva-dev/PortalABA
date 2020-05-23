//package com.portalaba.apirest.service;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//
//import com.portalaba.apirest.domain.Tratamento;
//
//public abstract class AbstractEmailService implements EmailService {
//	
//	//@Value("${default.sender}")
//	private String sender = "suporte.portalaba@gmail.com";
//	
//	@Override
//	public void sendOrderConfirmationEmail(Tratamento obj) {
//		SimpleMailMessage sm = prepareSimpleMailMessageFromTratamento(obj);
//		sendEmail(sm);
//	}
//
//	protected SimpleMailMessage prepareSimpleMailMessageFromTratamento(Tratamento obj) {
//		
//		SimpleMailMessage sm = new SimpleMailMessage();
//		//sm.setTo(obj.getAcompanhante().getEmailAcompanhante());
//		sm.setFrom(sender);
//		//sm.setSubject("Novo tratamento para o Paciente " + obj.getPaciente().getNome());
//		sm.setSentDate(new Date(System.currentTimeMillis()));
//		sm.setText(obj.toString());
//		return sm;
//	}
//	
////	@Override
////	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
////		SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
////		sendEmail(sm);
////	}
////	
////	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
////		SimpleMailMessage sm = new SimpleMailMessage();
////		sm.setTo(cliente.getEmail());
////		sm.setFrom(sender);
////		sm.setSubject("Solicitação de nova senha");
////		sm.setSentDate(new Date(System.currentTimeMillis()));
////		sm.setText("Nova senha: " + newPass);
////		return sm;
////	}
//}