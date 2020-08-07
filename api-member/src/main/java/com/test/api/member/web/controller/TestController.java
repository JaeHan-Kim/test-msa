package com.test.api.member.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}