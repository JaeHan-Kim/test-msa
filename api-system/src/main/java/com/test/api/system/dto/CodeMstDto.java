package com.test.api.system.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CodeMstDto {
	
	private Long id;
	
	private String codeMst;
	
	private String name;
	
	private String explain;
	
	private Boolean useYn;
	
	private Long regSeq;
	
	private Long modSeq;
	
	private String regIp;
	
	private String modIp;
	
	private LocalDateTime regDt;
	
	private LocalDateTime modDt;
}
