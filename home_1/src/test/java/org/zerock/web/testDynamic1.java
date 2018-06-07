package org.zerock.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardMapper;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class testDynamic1 {
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testDynamic()throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(3);
		cri.setKeyword("사용자10");
		cri.setSearchType("w");
		
		log.info("^0^0^0^0^0^0^0^0^======================================");
		
		List<BoardVO> list = mapper.listSearch(cri);
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getBno() + ": " + boardVO.getTitle());
		}
		log.info("^0^======================^0^=====================");
		
		log.info("사용자10 검색결과 COUNT 입니다: " + mapper.listSearchCount(cri));
	}

}
