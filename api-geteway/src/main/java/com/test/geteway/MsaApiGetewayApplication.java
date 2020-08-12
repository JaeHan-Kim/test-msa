package com.test.geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.test.geteway.filter.PreZuulFilter;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MsaApiGetewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaApiGetewayApplication.class, args);
	}
	
	@Bean
	public PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}
}
