/**
 * 
 */
package com.accolite.hrms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Class containing all application configuration.
 * 
 *
 */
@Configuration
@ComponentScan(basePackageClasses={com.accolite.hrms.rest.PackageInfo.class, PackageInfo.class, com.accolite.hrms.dto.mapper.PackageInfo.class})
@EnableJpaRepositories(basePackageClasses={com.accolite.hrms.repository.PackageInfo.class})
@EntityScan(basePackageClasses={com.accolite.hrms.entity.PackageInfo.class})
@PropertySource("classpath:application.properties")
public class AppConfig {
	
}
