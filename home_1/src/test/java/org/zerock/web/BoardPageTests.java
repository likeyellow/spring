package org.zerock.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardMapper;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class BoardPageTests {

	@Autowired
	BoardMapper mapper;
	
	int page = 3;
	
	@Test
	public void PageTest()throws Exception {
	
		List<BoardVO> list = mapper.listPage(page);
		
		for(BoardVO BoardVO : list) {
			log.info(BoardVO.getBno() +" : "+BoardVO.getTitle());
		}	
	}
	@Test
	public void CreteriaTest()throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = mapper.listCriteria(cri);
		
		for(BoardVO BoardVO : list) {
			log.info(BoardVO.getBno() + " : " + BoardVO.getTitle());
		}
	}
}
