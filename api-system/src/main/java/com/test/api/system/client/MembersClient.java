package com.test.api.system.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="member", url="http://localhost:8100")
public interface MembersClient {
	
	@GetMapping("/api/member/members")
	String getMembers();
}
