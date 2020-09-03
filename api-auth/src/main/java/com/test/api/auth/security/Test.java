package com.test.api.auth.security;

import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

public class Test extends ResourceOwnerPasswordResourceDetails {

	@Override
	public boolean isClientOnly() {
		return true;
	}
}
