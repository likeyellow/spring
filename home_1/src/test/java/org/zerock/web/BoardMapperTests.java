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

	//	System.out.println("������ ���̵�/��й�ȣ : " + name);
	}

	@Test
	public void testList2() {
	//	String result = mapper2.listAll2();

	//	System.out.println("��� ����Ʈ��... : " + result);
	}

	@Test
	public void testCeate2() {

	}

	@Test
	public void testGetEmail() {

	//	String email = mapper2.getEmail();

	//	System.out.println("�̸�����... : " + email);
	}

	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;

	@Test
	public void testAllList() throws Exception {

		for (int i = 0; i < 100; i++) {
			/*BoardVO vo = new BoardVO();
			log.info("insertTest ���Դϴ�" + mapper.create(vo));*/
			
			List<BoardVO> list = mapper.listAll();
			
			System.out.println("����Ʈ �Դϴ� : " + list);
		}
	}
}
