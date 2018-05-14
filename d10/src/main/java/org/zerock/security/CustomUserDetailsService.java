package org.zerock.security;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Data
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_= {@Autowired})
	private MemberMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username = id
		// �� ���� �� ��ť��Ƽ ����� �������� ��������
		
		
		log.info("loadUserByUserName: " + username);
		
		log.info("MemberMapper: " + mapper);
		
		MemberVO vo = mapper.read(username);
		
		/*User user = new User(vo.getUid(), vo.getUpw(), // MemberVO�� �����ͼ� �Ϸķ� ������ �� �� mapping�� ���ش�. authVO��ü�� auth�� ��ȯ��
				vo.getAuthList().stream().map(authVO -> new SimpleGrantedAuthority(authVO.getAuth()))
				.collect(Collectors.toList())
				);*/
		
		User user = new CustomMemberDetails(vo);
		
		/*return new User(username,"$2a$10$Vn33RF6LJDs26GFUMwEXL.lNEIIn0.C55Dsb9KwNqxxUdmQKELR7y",
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	*/
		return user;
	}
}
