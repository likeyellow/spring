package org.zerock.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	private String uid, upw, uname, email, grade;
	
	public MemberVO(String uid, String upw) {
		this.uid = uid;
		this.upw = upw;
		this.uname = "Sample User";
		this.grade = "P";
		
	}
}
