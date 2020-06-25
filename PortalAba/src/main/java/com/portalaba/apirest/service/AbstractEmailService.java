package com.portalaba.apirest.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.portalaba.apirest.domain.Tratamento;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOrderConfirmationEmail(Tratamento obj,String destinatario, String paciente) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromTratamento(obj,destinatario,paciente);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromTratamento(Tratamento obj,String destinatario, String paciente) {
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(destinatario);
		sm.setFrom(sender);
		sm.setSubject("Novo tratamento para o seu Anjinho " + paciente);
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplateTratamento(Tratamento obj,String destinatario, String paciente) {
		Context context = new Context();
		context.setVariable("tratamento", obj);
		context.setVariable("destinatario", destinatario);
		context.setVariable("paciente", paciente);
		return templateEngine.process("email/confirmacaoTratamento", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Tratamento obj,String destinatario, String paciente) {
		try {
		MimeMessage mm = prepareMimeMessageFromTratamento(obj,destinatario,paciente);
		sendHtmlEmail(mm);
		}catch (MessagingException e) {
			sendOrderConfirmationEmail(obj, destinatario, paciente);
		}
	}

	protected MimeMessage prepareMimeMessageFromTratamento(Tratamento obj, String destinatario, String paciente) throws MessagingException {
		MimeMessage mimeMessage =javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(destinatario);
		mmh.setFrom(sender);
		mmh.setSubject("Novo tratamento para o seu Anjinho" + paciente);
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateTratamento(obj, destinatario, paciente), true);
		return mimeMessage;
	}

}