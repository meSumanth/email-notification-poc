/**
 * 
 */
package com.demo.mail.dto;

import lombok.Data;

/**
 * @author va20070770
 *
 */

@Data
public class MailRequest {
	
	private String name;
	
	private String from;
	
	private String to;
	
	private String subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
