package org.zerock.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class CustomMemberDetails extends User {
	
	private MemberVO member;
	private String displayName;
	
	public CustomMemberDetails(String username, String password, Collection authorities) {
		super(username, password, authorities);
	}
	public CustomMemberDetails(MemberVO member) {
		
		this(member.getUid(), member.getUpw(), // MemberVO를 가져와서 일렬로 정렬을 한 후 mapping을 해준다. authVO객체의 auth로 변환함
				member.getAuthList().stream().map(authVO -> new SimpleGrantedAuthority(authVO.getAuth()))
		.collect(Collectors.toList())
		);
	this.member = member;
	
	this.displayName= member.getUname();
	}
	
}
