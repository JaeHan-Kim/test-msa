package com.test.api.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAuthApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiAuthApplication.class, args);
	}
/*	
	@Bean("jasyptStringEncrptor")
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		String jasyptKey = System.getProperty("jasypt.default.key");
	
		config.setPassword(jasyptKey);
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		
		return encryptor;
	}
*/
}
