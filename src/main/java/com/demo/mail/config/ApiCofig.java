/**
 * 
 */
package com.demo.mail.config;

import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * @author va20070770
 *
 */

@Component
public class ApiCofig {
	
	public FreeMarkerConfigurationFactoryBean factoryBean()
	{
		FreeMarkerConfigurationFactoryBean bean = new  FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates");
		return bean;
	}

}
