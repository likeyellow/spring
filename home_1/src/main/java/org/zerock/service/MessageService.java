package org.zerock.service;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MessageVO;

public interface MessageService {
	
	public void addMessage(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(@Param("uid") String uid, @Param("mno") Integer mno) throws Exception;
	
}
