package com.demo.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mail.dto.MailRequest;
import com.demo.mail.dto.MailResponse;
import com.demo.mail.service.MailService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableSwagger2
public class Application {
	
	@Autowired
	private MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}		
	
	@PostMapping(value = "/send-mail")
	public MailResponse sendMail(@RequestBody MailRequest mailRequest)
	{
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Sumanth V");
		
		return mailService.sendMail(mailRequest, map);
	}
	
	@Bean
	public Docket productApi() 
	{
	    return new Docket(DocumentationType.SWAGGER_2)
	           .select()                 
	           .apis(RequestHandlerSelectors.basePackage("com.demo.mail"))
	           .paths(PathSelectors.any())
	           .build();
	}

}
