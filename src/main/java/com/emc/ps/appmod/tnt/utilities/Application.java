package com.emc.ps.appmod.tnt.utilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class Application {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/appInfo", method = RequestMethod.GET)
	public String bookInfo() {
		return "Utilities Microservice is running!";
	}
	
	/*@Primary
	@Bean
	public RemoteTokenServices tokenService() {
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setCheckTokenEndpointUrl(
	      "http://tnt-auth-server-oauth.cfapps.io/uaa/oauth/check_token");
	    tokenService.setClientId("client");
	    tokenService.setClientSecret("secret");
	    return tokenService;
	}*/

}
