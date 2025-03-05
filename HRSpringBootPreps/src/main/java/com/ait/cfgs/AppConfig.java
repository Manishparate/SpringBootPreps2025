package com.ait.cfgs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.ait.service.HRServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("Rest template is created");
		return new RestTemplate();
	}

	@Bean
	@ConditionalOnMissingBean(HRServiceImpl.class)
	public HRServiceImpl getHRService() {
		return new HRServiceImpl();
	}

}
