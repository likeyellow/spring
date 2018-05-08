package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.search.SearchMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SearchMapperTests {

	@Autowired
	private SearchMapper mapper;
	
	@Test
	public void testArr1() {
		log.info(mapper.arr1(
				new String[] {"t","c"},
			//	null,
				"테스트")
				);
	}	
	
	@Test
	public void testMap1() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("t", "제목");
		map.put("c", "내용");
		
		log.info(mapper.map1(map));
	}
	
	@Test
	public void test1() {
		log.info(mapper.search1("title", "테스트"));
	}
	
	@Test
	public void test2() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("t", "테스트");
		map.put("c", "테스트");
		map.put("w", "테스트");
		
		log.info(new String[] {"t","c","w"});
	}
	
	
	@Test
	public void testNow() {
		
		log.info(mapper.getTime());
	}
		
}
