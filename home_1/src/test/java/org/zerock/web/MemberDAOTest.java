package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
// location 속성 경로에 xml 파일을 이용해서 스프링이 로딩됨
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime()throws Exception{
		
		System.out.println(dao.getTime());
	}
	@Test
	public void testInsertMember()throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setUserid("user01");
		vo.setUserpw("user01");
		vo.setUsername("USER01");
		vo.setEmail("user01@aaa.com");
		
		dao.insertMember(vo);
	}
}
