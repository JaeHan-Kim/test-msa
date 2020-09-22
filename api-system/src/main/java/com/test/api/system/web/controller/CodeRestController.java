package com.test.api.system.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.system.client.MembersClient;
import com.test.api.system.dto.CodeMstDto;
import com.test.api.system.service.CodeMstService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/system")
@RequiredArgsConstructor
public class CodeRestController {

	private final CodeMstService codeMstService;
	
	private final MembersClient membersClient;
	
	@GetMapping("/codeMsts")
	public List<CodeMstDto> codeMsts() {
		return codeMstService.getCodeMsts();
	}
	
	@PostMapping("/test")
	public String setReview() {
		
		String retur = membersClient.getMembers();
		log.info("{}", retur);
		// set new Review
		//writeReviewSource.writeReview().send(MessageBuilder.withPayload("1").build());
		
		return "write review";
	}
}
