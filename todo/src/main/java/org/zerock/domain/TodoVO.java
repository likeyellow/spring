package org.zerock.domain;

import java.sql.Date;

import lombok.Data;
import lombok.extern.log4j.Log4j;
@Log4j
@Data
public class TodoVO {
	private Integer tno;
	private String title;
	private String content;
	private Date regdate;

}
