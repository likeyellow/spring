package org.zerock.persistence;

import org.zerock.domain.MessageVO;

public interface MessageMapper {
	
	public void create(MessageVO vo)throws Exception;
	
	public MessageVO readMessage(Integer mno)throws Exception;
	
	public void updateState(Integer mno)throws Exception;

}
