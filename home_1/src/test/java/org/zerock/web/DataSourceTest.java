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
// location �Ӽ� ��ο� xml ������ �̿��ؼ� �������� �ε���
public class DataSourceTest {
	
	// @Autowired
	// �ν��Ͻ� ������ @Inject �ֳ����̼� ó���� DataSource�� �������� �����ؼ� ������ �ֹǷ� �����ڰ� ��ü ���� Ȥ�� �ٸ� �۾��� ���� �ʾƵ� ��
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection()throws Exception{
		
		try(Connection con = ds.getConnection()){
			System.out.println("connection con �� ��µ˴ϴ� : " + con);
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
		log.info("SqlSessionFactory �׽�Ʈ ���Դϴ� : " + factory);
	}
	
	@Test
	public void testOpen(){
		
		SqlSession session = factory.openSession();
		log.info("SqlSession ���� Ȯ�� ���Դϴ� : " + session);
		session.close();
		
	}
	
}
