package org.zerock.persistence;

import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;

public interface UserMapper {
	
	public UserVO login(LoginDTO dto)throws Exception;
	
}
