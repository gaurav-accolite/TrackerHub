/**
 * 
 */
package com.accolite.hrms;

import static com.accolite.hrms.utility.Constant.serverDirectoryName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.accolite.hrms.config.AppConfig;
import com.accolite.hrms.exception.SystemVariableNotFoundException;
/**
 * Spring boot main application to run HRMS application.
 * 
 * @author Avi Baraswal
 *
 */
@SpringBootApplication
@Import(AppConfig.class)
public class HRMSApplicationRunnr extends SpringBootServletInitializer {
	
	

	/**
	 * Runner method of HRMS application.
	 * 
	 */
	public static void main(String[] args) {
				SpringApplication.run(HRMSApplicationRunnr.class, args);
		
	}
}
