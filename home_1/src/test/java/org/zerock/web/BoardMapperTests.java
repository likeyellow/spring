package org.zerock.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper2;

	@Test
	public void testUserName() {

	//	String name = mapper2.getUserName("user00", "user00");

	//	System.out.println("유저의 아이디/비밀번호 : " + name);
	}

	@Test
	public void testList2() {
	//	String result = mapper2.listAll2();

	//	System.out.println("모든 리스트는... : " + result);
	}

	@Test
	public void testCeate2() {

	}

	@Test
	public void testGetEmail() {

	//	String email = mapper2.getEmail();

	//	System.out.println("이메일은... : " + email);
	}

	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;

	@Test
	public void testAllList() throws Exception {

		for (int i = 0; i < 100; i++) {
			/*BoardVO vo = new BoardVO();
			log.info("insertTest 중입니다" + mapper.create(vo));*/
			
			List<BoardVO> list = mapper.listAll();
			
			System.out.println("리스트 입니다 : " + list);
		}
	}
}
