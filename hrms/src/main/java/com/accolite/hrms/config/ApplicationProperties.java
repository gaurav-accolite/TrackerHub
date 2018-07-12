package com.accolite.hrms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")

public class ApplicationProperties {
	@Value("${database.username}")
	private String databaseUsername;
	
	@Value("${database.password}")
	private String databasePassword;
	
	@Value("${database.url}")
	private String databaseUrl;
	


	

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	
	
}
