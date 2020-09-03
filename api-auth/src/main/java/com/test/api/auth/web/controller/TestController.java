package com.test.api.auth.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.api.auth.security.User;

@RestController
public class TestController {

	/**
	 * 
	 * @param user
	 * @return
	 * @throws JsonProcessingException
	 */
	@PostMapping("/login")
	public String login(User user) throws JsonProcessingException {
		
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		h.setBasicAuth("auth_id", "auth_secret");
		
		HttpEntity<String> request = new HttpEntity<String>("grant_type=password&username=test&password=test", h);
		System.out.println(request.getBody());
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject("http://localhost:8095/oauth/token", request, String.class);
		
		return result;
	}
}
