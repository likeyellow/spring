package org.zerock.domain;

import java.sql.Date;

import lombok.Data;
@Data
public class MemberVO {

	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date regdate;
	private Date updatedate;
}
