package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {

	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
}
