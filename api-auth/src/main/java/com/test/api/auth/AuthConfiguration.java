package com.test.api.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
@SpringBootApplication
public class AuthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private ResourceServerProperties resourceServerProperties;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		super.configure(endpoints);
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService);
		super.configure(clients);
	}
	
	@Bean
	@Primary
	public JdbcClientDetailsService jdbcClientDetailsService(DataSource dataSource) {
    	// Jdbc(H2 데이터베이스)를 이용한 Oauth client 정보등록을 위한 설정입니다.
		return new JdbcClientDetailsService(dataSource);
	}

	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		// JWT key-value 방식을 사용하기 위한 설정입니다.
		JwtAccessTokenConverter accessTockenConverter = new JwtAccessTokenConverter();
		accessTockenConverter.setSigningKey(resourceServerProperties.getJwt().getKeyValue());
		
		return accessTockenConverter;
	}
}
