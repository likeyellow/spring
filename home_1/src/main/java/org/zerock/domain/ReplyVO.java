package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Integer rno;
	private Integer bno;
	private String replytext;
	private String replyer;
	
	private Date regdate;
	private Date updatedate;
}
