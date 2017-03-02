/*package com.emc.ps.appmod.tnt.utilities.config;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@ServiceScan
@Configuration
@Profile("cloud")
public class CloudConfig {

	@Bean
	public Cloud cloud() {
		return new CloudFactory().getCloud();
	}

	@Bean
	public ApplicationInstanceInfo applicationInstanceInfo() {
		return cloud().getApplicationInstanceInfo();
	}

}*/
