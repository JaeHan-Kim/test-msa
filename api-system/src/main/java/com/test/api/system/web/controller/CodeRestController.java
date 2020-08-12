package com.test.api.system.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.system.dto.CodeMstDto;
import com.test.api.system.service.CodeMstService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/system")
@RequiredArgsConstructor
public class CodeRestController {

	private final CodeMstService codeMstService;
	
	@GetMapping("/codeMsts")
	public List<CodeMstDto> codeMsts() {
		return codeMstService.getCodeMsts();
	}
}
