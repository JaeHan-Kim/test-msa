package com.test.api.system.service;

import org.springframework.stereotype.Service;

import com.test.api.system.dto.CodeMstDto;
import com.test.api.system.entity.CodeMst;
import com.test.api.system.repository.CodeMstRepository;

import lombok.RequiredArgsConstructor;

import static com.test.api.system.utils.ObjectMapperUtils.map;
import static com.test.api.system.utils.ObjectMapperUtils.mapList;

@Service
@RequiredArgsConstructor
public class CodeMstService {

	private final CodeMstRepository codeMstRepository;

	public CodeMstDto createCodeMst(CodeMstDto data) {
		
		CodeMst entity = codeMstRepository.save(map(data, CodeMst.class));
		
		return map(entity, CodeMstDto.class);
	}
}
