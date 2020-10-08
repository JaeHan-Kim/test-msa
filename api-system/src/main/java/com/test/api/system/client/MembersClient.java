package com.test.api.system.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="MSA-MEMBER-API")
public interface MembersClient {
	
	@GetMapping("/api/member/members")
	String getMembers(@RequestHeader("TEST-HEADER") String tHeader);
}
