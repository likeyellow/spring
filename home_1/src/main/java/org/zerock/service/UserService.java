package org.zerock.service;

import java.sql.Date;

import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto)throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
	
}
