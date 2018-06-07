package org.zerock.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardMapper;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class BoardPageTests {

	@Inject
	BoardMapper mapper;
	
	
	
	@Test
	public void test1() {
		log.info(mapper.getClass().getName());
	}
	
	@Test
	public void testListPage()throws Exception {
	
		int page = 3;
		
		List<BoardVO> list = mapper.listPage(page);
		
		for(BoardVO BoardVO : list) {
			log.info(BoardVO.getBno() +" : "+BoardVO.getTitle());
		}	
	}
	@Test
	public void testListCreteria()throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(3);
		cri.setPerPageNum(10);
//		
//		int list = mapper.listCriteria(cri);
//		
		List<BoardVO> list = mapper.listCriteria(cri);
		for(BoardVO BoardVO : list) {
			log.info(BoardVO.getBno() + " : " + BoardVO.getTitle());
		}
	}
	@Test
	public void testURI()throws Exception{
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/sboard/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		log.info("/sboard/read?bno=12&perPageNum=20");
		log.info(uriComponents.toString());
				
	}
	
	@Test
	public void testURI2()throws Exception{
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("sboard","read")
				.encode();
		
		log.info("/sboard/read?bno=12&perPageNum=20");
		log.info(uriComponents.toString());
	}
}
