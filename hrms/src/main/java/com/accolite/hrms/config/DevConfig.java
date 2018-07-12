package com.accolite.hrms.config;

import javax.sql.DataSource;

import org.h2.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DevConfig {
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	
	@Bean
	@Profile("dev-postgres")
	public DataSource dataSource() {
		
		return DataSourceBuilder
				.create()
				.driverClassName(org.postgresql.Driver.class.getName())
				.username(applicationProperties.getDatabaseUsername())
				.password(applicationProperties.getDatabasePassword())
				.url(applicationProperties.getDatabaseUrl())			
					.build();
	} 
	
	@Bean
	@Profile("dev-h2")
	public DataSource dataSource2() {
		return DataSourceBuilder
				.create()
				.driverClassName(Driver.class.getName())
				.url("jdbc:h2:mem:accolite-apps;INIT=create schema if not exists hrms;")
				.build();
	}
}
