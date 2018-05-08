package org.zerock.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SqlSessionTests {

	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory factory;
	
	@Test
	public void testFactory() {
		
		log.info(factory);
	}
	
	@Test
	public void openTest() {
		SqlSession session = factory.openSession();
		log.info(session);
		session.close();
	}
	@Test
	public void selectTest() {
		SqlSession session = factory.openSession();
		String time = (String)session.selectOne("org.zerock.mapper.TimeMapper.getTime");
		log.info(time);
		session.close();
		
	}
}
