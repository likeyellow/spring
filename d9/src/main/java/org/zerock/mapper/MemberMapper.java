package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	@Select("select * from tbl_member_secu where uid = #{uid}")
	public MemberVO read(String uid);
	
}
