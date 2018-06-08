package org.zerock.domain;

import java.sql.Date;

import lombok.Data;
@Data
public class MessageVO {
	
	private Integer mno;
	private String targetid;
	private String sender;
	private String message;
	private Date opendate;
	private Date senddate;

}
