package org.zerock.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
// location 속성 경로에 xml 파일을 이용해서 스프링이 로딩됨
public class DataSourceTest {
	
	// @Autowired
	// 인스턴스 변수의 @Inject 애노테이션 처리된 DataSource는 스프링이 생성해서 주입해 주므로 개발자가 객체 생성 혹은 다른 작업을 하지 않아도 됨
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection()throws Exception{
		
		try(Connection con = ds.getConnection()){
			System.out.println("connection con 이 출력됩니다 : " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCon()throws SQLException{
		
		log.info(ds);
		
		for(int i =0; i<10; i++) {
			Connection con = ds.getConnection();
			log.info(con);
			con.close();
		}
	}
	
	@Autowired
	SqlSessionFactory factory;
	
	@Test
	public void testExists() {
		log.info("SqlSessionFactory 테스트 중입니다 : " + factory);
	}
	
	@Test
	public void testOpen(){
		
		SqlSession session = factory.openSession();
		log.info("SqlSession 오픈 확인 중입니다 : " + session);
		session.close();
		
	}
	
}
