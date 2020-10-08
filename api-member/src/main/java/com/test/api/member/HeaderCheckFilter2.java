package com.test.api.member;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderCheckFilter2 extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("test header filter");
		log.info("test {}", request.getHeader("TEST-HEADER"));
		
		filterChain.doFilter(request, response);
	}
}
