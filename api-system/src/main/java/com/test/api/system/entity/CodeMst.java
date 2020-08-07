package com.test.api.system.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "CodeMst")
@Getter @Setter
public class CodeMst {

	@Id
	@Column(name = "CODE_MST_SEQ")
	@GeneratedValue
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