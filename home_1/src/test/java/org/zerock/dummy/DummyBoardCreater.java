package org.zerock.dummy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class DummyBoardCreater {

	/*
	@Autowired
	private BoardMapper mapper; */
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testInsert() throws Exception {
		
		for(int i = 0; i<200; i++) {
			
			BoardVO vo = new BoardVO();
			vo.setTitle("제목"+i);
			vo.setContent("내용"+i);
			vo.setWriter("사용자"+i);
			
			
			//mapper.create(vo);
			
			dao.create(vo);
			
		}
	}

}
