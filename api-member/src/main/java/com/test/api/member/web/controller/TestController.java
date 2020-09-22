package com.test.api.member.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.member.dto.MemberDto;
import com.test.api.member.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/members")
	@ResponseBody
	public MemberDto getMember() {
		log.info("test member!!!");

		return new MemberDto(1l, "kimjaehan");
	}
}
