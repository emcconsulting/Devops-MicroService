package com.emc.ps.appmod.tnt.utilities.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("!cloud")
public class LocalConfig {

	@Autowired
	Environment environment;

	@Profile("local")
	@Bean
	public DataSource dataSource2() {
		return createBasicDataSource2(environment.getProperty("url"), environment.getProperty("driver-class-name"),
				environment.getProperty("username"), environment.getProperty("password"));
	}

	protected DriverManagerDataSource createBasicDataSource2(String jdbcUrl, String driverClass, String userName,
			String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(jdbcUrl);
		dataSource.setDriverClassName(driverClass);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}

}
