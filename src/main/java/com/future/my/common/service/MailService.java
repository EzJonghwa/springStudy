package com.future.my.common.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service

public class MailService {

	@Autowired
	private JavaMailSender mailSender;
//	메시지를 비동기로 하는 이유는 보내는 사람들 마다 보내는 시간이 다르기에 + void 로 설정
	
	@Async
	public void sendMail(String to, String title, String content) {            
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper;
		
		try {
			messageHelper = new MimeMessageHelper(message , true, "UTF-8");
			messageHelper.setFrom("jj2bae@gmail.com", "관리자");
			messageHelper.setSubject(title);
			messageHelper.setTo(to);
			messageHelper.setText(content);
			mailSender.send(message);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
