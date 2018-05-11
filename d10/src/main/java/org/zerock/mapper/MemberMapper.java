package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.domain.MemberAuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	@Insert("insert into tbl_member_secu (uid,upw,uname) values (#{uid},#{upw}, #{uname})")
	public void insert(MemberVO vo);
	
	@Insert("insert into tbl_member_auth (uid, auth) values (#{uid}, #{auth}) ")
	public void insertAuth(MemberAuthVO vo);
	
	public MemberVO read(String uid);
}
