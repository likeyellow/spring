package org.zerock.mappertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.TodoVO;
import org.zerock.mapper.TodoMapper;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoTests {

	@Setter(onMethod_= {@Autowired})
	private TodoMapper mapper;
	
	@Test
	public void testInsert() {
		for(int i=0; i<10; i++) {
			TodoVO vo = new TodoVO();
			
			vo.setTitle("�׽�Ʈ����1" + i);
			vo.setContent("�׽�Ʈ����1" + i);
			
			//String result = mapper.insert(vo);
			log.info("insertTest ���Դϴ�" + mapper.create(vo));
		}
	}	
	@Test
	public void testSelect() {

			log.info("selectTest ���Դϴ�" + mapper.read(1));	
		}
	
	@Test
	public void testUpdate() {
		TodoVO vo = mapper.read(2);
		vo.setTitle("Update Title");
		vo.setContent("�� ����� ����");
		
		log.info("updateTest ���Դϴ�" + mapper.update(vo));
	}
	@Test
	public void testDel() {
		
		log.info("deleteTest ���Դϴ�" + mapper.delete(9));
	}
	
	
	
}

