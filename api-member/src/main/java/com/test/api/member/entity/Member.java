package com.test.api.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Member {

	@Id
	@Column(name = "member_no")
	@GeneratedValue
	private Long id;
}