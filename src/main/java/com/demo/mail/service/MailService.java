/**
 * 
 */
package com.demo.mail.service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.demo.mail.dto.MailRequest;
import com.demo.mail.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author va20070770
 *
 */

@Service	
public class MailService {
	
	@Autowired
	private Configuration configuration;
	
	@Autowired
	private JavaMailSender mailSender;

	public MailResponse sendMail(MailRequest mailRequest, Map<String, Object> paramMap)
	{
		MailResponse response = new MailResponse();
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			
			Template template = configuration.getTemplate("email-template.ftl");
			String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, paramMap);
			
			helper.setTo(mailRequest.getTo());
			helper.setFrom(mailRequest.getFrom());
			helper.setText(content, true);
			helper.setSubject(mailRequest.getSubject());
			mailSender.send(message);
			
			response.setMessage("Mail Sent To"+ mailRequest.getTo());
			response.setStatus("Success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

}
