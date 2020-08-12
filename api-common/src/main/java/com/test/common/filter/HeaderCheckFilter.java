package com.test.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.owasp.encoder.Encode;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderCheckFilter extends OncePerRequestFilter {

	private final String accessKey;
	
	public HeaderCheckFilter(String accessKey) {
		this.accessKey = accessKey;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("test header filter");
		log.info("this accessKey {}", this.accessKey);
		log.info("test {}", request.getHeader("X-ZUUL-ACCESSKEY"));
		
		if (!StringUtils.equals(this.accessKey, request.getHeader("X-ZUUL-ACCESSKEY"))) {
			Map<String, Object> message = new HashMap<>();
			message.put("code", HttpServletResponse.SC_UNAUTHORIZED);
			message.put("message", "UNAUTHORIZED");
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(message);
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().write(Encode.forHtmlContent(json));
			response.getWriter().flush();
			
			return;
		}
		
		filterChain.doFilter(request, response);
	}

}
