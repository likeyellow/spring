package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;
import org.zerock.persistence.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserMapper user;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return user.login(dto);
	}

}
