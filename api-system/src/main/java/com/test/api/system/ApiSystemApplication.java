package com.test.api.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.test.common.filter.HeaderCheckFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApiSystemApplication {
	
    @Value("${header.access-key}")
    private String accessKey;
    
	public static void main(String[] args) {
		SpringApplication.run(ApiSystemApplication.class, args);
	}
	/*
	@Bean
	public HeaderCheckFilter headerCheckFilter() {
		return new HeaderCheckFilter(accessKey);
	}
	*/
	
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
	@Bean
	public ApplicationRunner appli() {

		return args -> { 

			//String ip = getRemoteAddr(getRequest());
			
			log.info("------------------------------------------------");
			//log.info("IP : {} ", ip);
			log.info("------------------------------------------------");
		};
	}
	
    /**
     * 클라이언트 ip 반환
     * @return
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String[] headerKeys = { "X-Forwareded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR" };
        String ip = null;
        for (String key : headerKeys) {
            ip = request.getHeader(key);

            if (StringUtils.isNotEmpty(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
    
    /**
     * request 객체를 반환함.
     */
    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * response 객체를 반환함.
     */
    public HttpServletResponse getResponse() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getResponse();
    }
}
