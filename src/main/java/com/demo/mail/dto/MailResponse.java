/**
 * 
 */
package com.demo.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author va20070770
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {
	
	private String message;
	
	private String status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
